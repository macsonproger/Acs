package com.example.lr_4.utils;

import com.example.lr_4.models.AuditEvent;

public interface EventLogger {

    void log(Object entity, AuditEvent event);

}
