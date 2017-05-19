package com.birelandef.dao;

import com.birelandef.entities.Competition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 18/05/17.
 */
@EnableTransactionManagement
@Repository("cmptdao")
public class CompetitionDAO extends AbstractDAO<Competition, String>{
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Competition> getAllEntity() {
        return em.createQuery("from Competition", Competition.class).getResultList();
    }

    public Competition findEntityById(String idEntity) {
        return em.createQuery("from Competition where CompetitionId='" + idEntity + "'", Competition.class).getSingleResult();
    }
}