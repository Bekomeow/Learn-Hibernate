package com.beko.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity<T extends Serializable> implements BaseEntity<T> {
    private Instant createdAt;
    private String createdBy;

    @PrePersist
    public void prePersist() {
        setCreatedAt(Instant.now());
    }
}
