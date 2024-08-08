package com.beko.dao;

import com.beko.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;
import java.util.List;

public interface Dao<K extends Serializable, E extends BaseEntity<K>> {
    E save(E entity);

    void delete(K id);

    void update(E entity);

    Optional<E> findById(K id);

    List<E> findAll();
}
