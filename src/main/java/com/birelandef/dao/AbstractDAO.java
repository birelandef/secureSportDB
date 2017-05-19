package com.birelandef.dao;

import com.birelandef.entities.Sportsmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
@EnableTransactionManagement
public abstract class AbstractDAO<T, Id> implements DAO<T, Id> {
    @PersistenceContext
    protected EntityManager em;

    @Autowired
    JdbcTemplate template;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addEntity(T entity) {
        em.persist(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEntity(T entity) {
        removeEntity(entity);
        addEntity(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removeEntity(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
