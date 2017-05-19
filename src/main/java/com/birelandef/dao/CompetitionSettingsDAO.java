package com.birelandef.dao;

import com.birelandef.entities.CompetitionSettings;
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
@Repository("cmptstdao")
public class CompetitionSettingsDAO extends AbstractDAO<CompetitionSettings, CompetitionSettingsId>{
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<CompetitionSettings> getAllEntity() {
        return em.createQuery("from Judge", CompetitionSettings.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addEntity(CompetitionSettings entity) {
        em.merge(entity);
    }

    public CompetitionSettings findEntityById(CompetitionSettingsId idEntity) {
        return em.createQuery("from Judge where trainerid='" + idEntity.getTrainer().gettDocId()
                + "' and competitionid='" + idEntity.getCompetition().getCompetitionId()+ "'",
                CompetitionSettings.class).getSingleResult();
    }
}
