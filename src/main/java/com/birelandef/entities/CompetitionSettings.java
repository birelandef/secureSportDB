package com.birelandef.entities;

import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.ProgramType;
import com.birelandef.utils.CompetitionSettingsId;

import javax.persistence.*;

/**
 * Created by sophie on 18/05/17.
 */
@Entity
@Table(name = "Judge")
@AssociationOverrides({
        @AssociationOverride(name = "pk.trainer",
                joinColumns = @JoinColumn(name = "trainerId")),
        @AssociationOverride(name = "pk.competition",
                joinColumns = @JoinColumn(name = "competitionId")) })
public class CompetitionSettings {
    @EmbeddedId
    CompetitionSettingsId pk;
    ProgramType program;
    ClassType classType;

    public CompetitionSettingsId getPk() {
        return pk;
    }

    public void setPk(CompetitionSettingsId pk) {
        this.pk = pk;
    }

    public ProgramType getProgram() {
        return program;
    }

    public void setProgram(ProgramType program) {
        this.program = program;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetitionSettings that = (CompetitionSettings) o;

        if (!pk.equals(that.pk)) return false;
        if (program != that.program) return false;
        return classType == that.classType;

    }

    @Override
    public int hashCode() {
        int result = pk.hashCode();
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (classType != null ? classType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompetitionSettings{" +
                "pk=" + pk +
                ", program=" + program +
                ", classType=" + classType +
                '}';
    }
}
