package com.birelandef.dao;

import com.birelandef.entities.CompetitionResult;
import com.birelandef.utils.CompetitionResultId;
import com.birelandef.utils.CompetitionSettingsId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 19/05/17.
 */
@EnableTransactionManagement
@Repository("cmprsltdao")
public class CompetitionResultDAO extends AbstractDAO<CompetitionResult, CompetitionResultId>{
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<CompetitionResult> getAllEntity() {
        return em.createQuery("from TakePart", CompetitionResult.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addEntity(CompetitionResult entity) {
        em.merge(entity);
    }

    public CompetitionResult findEntityById(CompetitionResultId idEntity) {
        return em.createQuery("from TakePart where pairid='" + idEntity.getPair().getPairId()
                + "' and competitionid='" + idEntity.getCompetition().getCompetitionId()+ "'",
                CompetitionResult.class).getSingleResult();
    }
}
