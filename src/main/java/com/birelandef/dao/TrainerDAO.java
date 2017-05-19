package com.birelandef.dao;

import com.birelandef.entities.Trainer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 16/05/17.
 */
@EnableTransactionManagement
@Repository("trnrdao")
public class TrainerDAO extends AbstractDAO<Trainer, String>{
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Trainer> getAllEntity() {
        return em.createQuery("from Trainer", Trainer.class).getResultList();
    }

    public Trainer findEntityById(String idEntity) {
        return em.createQuery("from Trainer where tDocId='" + idEntity + "'", Trainer.class).getSingleResult();
    }
}
