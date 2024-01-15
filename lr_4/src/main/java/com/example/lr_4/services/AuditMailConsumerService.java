package com.example.lr_4.services;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.example.lr_4.models.AuditMessage;
import com.example.lr_4.repositories.MailingRulesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditMailConsumerService {
    private final MailingRulesRepository mailingRulesRepository;

    private final MailingService mailingService;

    @JmsListener(destination = "${application.topic.audit}")
    public void receive(AuditMessage auditMessage) {
        List<String> emails = mailingRulesRepository.findEmailByTableName(auditMessage.getTable());

        emails.forEach(email -> mailingService.sendSimpleEmail(email, auditMessage));
    }
}
