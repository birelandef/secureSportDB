package com.birelandef.utils;

import com.birelandef.entities.Competition;
import com.birelandef.entities.Pair;
import com.birelandef.entities.Trainer;

import javax.lang.model.element.PackageElement;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by sophie on 18/05/17.
 */
@Embeddable
public class CompetitionResultId implements java.io.Serializable{

    @ManyToOne
    private Competition competition;
    @ManyToOne
    private Pair pair;

    public CompetitionResultId() {
    }

    public CompetitionResultId(Competition competition, Pair pair) {
        this.competition = competition;
        this.pair = pair;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionResultId that = (CompetitionResultId) o;

        if (!competition.equals(that.competition)) return false;
        return pair.equals(that.pair);

    }

    @Override
    public int hashCode() {
        int result = competition.hashCode();
        result = 31 * result + pair.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CompetitionResultId{" +
                "competition=" + competition +
                ", pair=" + pair +
                '}';
    }
}
