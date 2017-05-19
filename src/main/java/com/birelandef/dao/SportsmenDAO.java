package com.birelandef.dao;

import com.birelandef.entities.Sportsmen;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 15/05/17.
 */
@EnableTransactionManagement
@Repository("sprtdao")
public class SportsmenDAO extends AbstractDAO<Sportsmen, String> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Sportsmen> getAllEntity() {
        return em.createQuery("from Sportsmen", Sportsmen.class).getResultList();
    }

    public Sportsmen findEntityById(String idEntity) {
        return em.createQuery("from Sportsmen where DocId='" + idEntity + "'", Sportsmen.class).getSingleResult();
    }
}
