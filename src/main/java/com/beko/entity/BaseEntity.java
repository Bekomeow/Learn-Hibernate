package com.beko.entity;

public interface BaseEntity<T> {
    T getId();

    void setId(T id);
}
