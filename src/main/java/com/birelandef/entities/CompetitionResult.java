package com.birelandef.entities;

import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.ProgramType;
import com.birelandef.utils.CompetitionResultId;
import com.birelandef.utils.CompetitionSettingsId;
import com.birelandef.utils.IdGenerator;

import javax.persistence.*;

/**
 * Created by sophie on 18/05/17.
 */
@Entity
@Table(name = "TakePart")
@AssociationOverrides({
        @AssociationOverride(name = "pk.pair",
                joinColumns = @JoinColumn(name = "pairId")),
        @AssociationOverride(name = "pk.competition",
                joinColumns = @JoinColumn(name = "competitionId")) })
public class CompetitionResult {
    @EmbeddedId
    CompetitionResultId pk;
    int score;
    int point;
    final String competitionResultId;

    public CompetitionResult() {
        competitionResultId = IdGenerator.generatorId();
    }

    public CompetitionResultId getPk() {
        return pk;
    }

    public void setPk(CompetitionResultId pk) {
        this.pk = pk;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionResult that = (CompetitionResult) o;

        if (score != that.score) return false;
        if (point != that.point) return false;
        return pk.equals(that.pk);

    }

    @Override
    public int hashCode() {
        int result = pk.hashCode();
        result = 31 * result + score;
        result = 31 * result + point;
        return result;
    }

    @Override
    public String toString() {
        return "CompetitionResult{" +
                "pk=" + pk +
                ", score=" + score +
                ", point=" + point +
                '}';
    }
}
