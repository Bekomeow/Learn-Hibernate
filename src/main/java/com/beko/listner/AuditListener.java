package com.beko.listner;

import com.beko.entity.AuditableEntity;

import javax.persistence.PrePersist;
import java.time.Instant;

public class AuditListener {

    @PrePersist
    public void prePersist(AuditableEntity<?> entity) {
        entity.setCreatedAt(Instant.now());
    }
}

