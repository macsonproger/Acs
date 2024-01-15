package com.example.lr_4.services;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.example.lr_4.models.AuditEvent;
import com.example.lr_4.models.AuditMessage;
import com.example.lr_4.models.CreateMessage;
import com.example.lr_4.models.DeleteMessage;
import com.example.lr_4.utils.EventLogger;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditProducerService implements EventLogger {

    private final JmsTemplate jmsTemplate;

    @Value("${application.topic.audit}")
    private String topicName;

    @Override
    public void log(Object entity, AuditEvent event) {
        AuditMessage auditMessage = null;

        switch (event) {
            case CREATE -> {
                CreateMessage createMessage = new CreateMessage();
                createMessage.setCreatedObject(entity);
                auditMessage = createMessage;
            }
            case DELETE -> {
                DeleteMessage deleteMessage = new DeleteMessage();
                deleteMessage.setDeletedObject(entity);
                auditMessage = deleteMessage;
            }
        }

        auditMessage.setDatetime(LocalDateTime.now());
        auditMessage.setEvent(event);

        auditMessage.setTable(entity.getClass().getAnnotation(Table.class).name());

        jmsTemplate.convertAndSend(topicName, auditMessage);
    }


}
