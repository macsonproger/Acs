package com.example.lr_4.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.example.lr_4.models.AuditEntity;
import com.example.lr_4.models.AuditMessage;
import com.example.lr_4.repositories.AuditRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditMessageConsumerService {
    private final AuditRepository auditRepository;

    @Transactional
    @JmsListener(destination = "${application.topic.audit}")
    public void receive(AuditMessage auditMessage) {
        AuditEntity audit = new AuditEntity();
        audit.setId(UUID.randomUUID());
        audit.setEvent(auditMessage.getEvent());
        audit.setTable(auditMessage.getTable());
        audit.setDatetime(auditMessage.getDatetime());
        audit.setInfo(auditMessage.getInfo());

        auditRepository.save(audit);
    }
}
