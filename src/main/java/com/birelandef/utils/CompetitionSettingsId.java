package com.birelandef.utils;

import com.birelandef.entities.Competition;
import com.birelandef.entities.Trainer;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by sophie on 18/05/17.
 */
@Embeddable
public class CompetitionSettingsId implements java.io.Serializable{

    @ManyToOne(cascade = CascadeType.DETACH)
    private Competition competition;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Trainer trainer;

    public Competition getCompetition() {
        return competition;
    }

    public CompetitionSettingsId() {
    }

    public CompetitionSettingsId(Competition competition, Trainer trainer) {
        this.competition = competition;
        this.trainer = trainer;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionSettingsId that = (CompetitionSettingsId) o;

        if (!competition.equals(that.competition)) return false;
        return trainer.equals(that.trainer);

    }

    @Override
    public int hashCode() {
        int result = competition.hashCode();
        result = 31 * result + trainer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CompetitionSettingsId{" +
                "competition=" + competition +
                ", trainer=" + trainer +
                '}';
    }
}
