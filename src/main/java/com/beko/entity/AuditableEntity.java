package com.beko.entity;

import com.beko.listner.AuditListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditListener.class)
public abstract class AuditableEntity<T extends Serializable> implements BaseEntity<T> {
    private Instant createdAt;
    private String createdBy;
}
