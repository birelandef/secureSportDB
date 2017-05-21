package com.birelandef.entities;

import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.CompetitionType;
import com.birelandef.entities.enums.ProgramType;
import com.birelandef.utils.IdGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sophie on 15/05/17.
 */
@Entity
public class Competition {
    @Id
    private final String competitionId;
    private String name;
    private int rate;
    private CompetitionType competitionType;
    private Date date;
    private String location;
    private int scorePerPair;

    private ProgramType program;
    private ClassType classType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "Judge",
            joinColumns = @JoinColumn(name = "competitionId", updatable = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = "trainerId", updatable = false, nullable = false))
    private List<Trainer> invitedJudgers;

    public List<Trainer> getInvitedJudgers() {
        return invitedJudgers;
    }

    public void setInvitedJudgers(List<Trainer> invitedJudger) {
        this.invitedJudgers = invitedJudger;
    }

    public Competition() {
        competitionId = IdGenerator.generatorId();
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

    public String getCompetitionId() {
        return competitionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getScorePerPair() {
        return scorePerPair;
    }

    public void setScorePerPair(int maxPoint) {
        this.scorePerPair = maxPoint;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition that = (Competition) o;

        if (rate != that.rate) return false;
        if (scorePerPair != that.scorePerPair) return false;
        if (!competitionId.equals(that.competitionId)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (competitionType != that.competitionType) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (program != that.program) return false;
        if (classType != that.classType) return false;
        return invitedJudgers != null ? invitedJudgers.equals(that.invitedJudgers) : that.invitedJudgers == null;

    }

    @Override
    public int hashCode() {
        int result = competitionId.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + (competitionType != null ? competitionType.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + scorePerPair;
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (classType != null ? classType.hashCode() : 0);
        result = 31 * result + (invitedJudgers != null ? invitedJudgers.hashCode() : 0);
        return result;
    }

}
