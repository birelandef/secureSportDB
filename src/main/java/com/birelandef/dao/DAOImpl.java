package com.birelandef.dao;

import com.birelandef.Sportsmen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
@Repository
public class DAOImpl implements DAO {
    @PersistenceContext
    private EntityManager em;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Sportsmen sportsmen) {
        em.persist(sportsmen);
    }

    public List<Sportsmen> getAll() {
        return em.createQuery("from Sportsmen", Sportsmen.class).getResultList();
    }
}
