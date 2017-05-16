package com.birelandef.entities;

import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by sophie on 14/05/17.
 */
@javax.persistence.Entity
public class Pair {
    @Id
    private String pairId;
    private String  malePartnerId;
    private String femalePartnerId;
    private int score;
    private double averageScore;
    private String club;

    public String getPairId() {
        return pairId;
    }

    public void setPairId(String pairId) {
        this.pairId = pairId;
    }

    public String getMalePartnerId() {
        return malePartnerId;
    }

    public void setMalePartnerId(String malePartnerId) {
        this.malePartnerId = malePartnerId;
    }

    public String getFemalePartnerId() {
        return femalePartnerId;
    }

    public void setFemalePartnerId(String femalePartnerId) {
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
