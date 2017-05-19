package com.birelandef.dao;

import com.birelandef.entities.Pair;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 17/05/17.
 */
@EnableTransactionManagement
@Repository("prdao")
public class PairDAO extends AbstractDAO<Pair, String>{

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Pair> getAllEntity() {
        return em.createQuery("from Pair", Pair.class).getResultList();
    }

    public Pair findEntityById(String idEntity) {
        return em.createQuery("from Pair where pairId='" + idEntity + "'", Pair.class).getSingleResult();
    }
}
