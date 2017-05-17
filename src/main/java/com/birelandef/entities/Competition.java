package com.birelandef.entities;

import com.birelandef.entities.enums.CompetitionType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by sophie on 15/05/17.
 */
@Entity
public class Competition {
    @Id
    private String CompetitionId;
    private String name;
    private int rate;
    private CompetitionType competitionType;
    private Date date;
    private String location;
    private int maxPoint;

    public Competition() {
    }

    public String getCompetitionId() {
        return CompetitionId;
    }

    public void setCompetitionId(String competitionId) {
        CompetitionId = competitionId;
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

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "CompetitionId=" + CompetitionId +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", competitionType=" + competitionType +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", maxPoint=" + maxPoint +
                '}';
    }
}
