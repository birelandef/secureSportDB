package com.birelandef.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
@javax.persistence.Entity
public class Pair {

    @Id
    private String pairId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "malePartnerId", referencedColumnName = "docId")
    private Sportsmen  malePartnerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "femalePartnerId", referencedColumnName = "docId")
    private Sportsmen femalePartnerId;

    private int score;
    private double averageScore;
    private String club;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TakePart",
            joinColumns = @JoinColumn(name = "competitionId"),
            inverseJoinColumns = @JoinColumn(name = "pairId"))
    private List<Competition> competitions;

    public String getPairId() {
        return pairId;
    }

    public void setPairId(String pairId) {
        this.pairId = pairId;
    }

    public Sportsmen getMalePartnerId() {
        return malePartnerId;
    }

    public void setMalePartnerId(Sportsmen malePartnerId) {
        this.malePartnerId = malePartnerId;
    }

    public Sportsmen getFemalePartnerId() {
        return femalePartnerId;
    }

    public void setFemalePartnerId(Sportsmen femalePartnerId) {
        this.femalePartnerId = femalePartnerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Pair() {
    }

    @Override
    public String toString() {
        return "Pair{" +
                "pairId=" + pairId +
                ", malePartnerId=" + malePartnerId +
                ", femalePartnerId=" + femalePartnerId +
                ", score=" + score +
                ", averageScore=" + averageScore +
                ", club='" + club + '\'' +
                '}';
    }
}
