package com.birelandef.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
public interface DAO<T, Id> {

    /**
     * Add the entity to storage
     *
     * @param entity
     */
    void addEntity(T entity);

    /**
     * Get all entity from storage
     *
     * @return
     */
    List<T> getAllEntity();

    /**
     * Find entyty by id
     *
     * @param idEntity
     * @return found entity
     */
    T findEntityById(Id idEntity);

    /**
     * Update the entity
     *
     * @param entity
     */
    void updateEntity(T entity);

    /**
     * Remove the entity
     *
     * @param entity
     */
    void removeEntity(T entity);

    public JdbcTemplate getTemplate();
}
