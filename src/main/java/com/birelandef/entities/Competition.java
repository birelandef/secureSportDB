package com.birelandef.entities;

import com.birelandef.entities.enums.CompetitionType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by sophie on 15/05/17.
 */
@Entity
public class Competition {
    @Id
    private String competitionId;
    private String name;
    private int rate;
    private CompetitionType competitionType;
    private Date date;
    private String location;
    private int scorePerPair;

    public Competition() {
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
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
    public String toString() {
        return "Competition{" +
                "competitionId=" + competitionId +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", competitionType=" + competitionType +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", maxPoint=" + scorePerPair +
                '}';
    }
}
