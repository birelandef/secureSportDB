package com.birelandef.entities;

import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by sophie on 14/05/17.
 */
@javax.persistence.Entity
public class Pair {
    @Id
    private BigInteger pairId;
    private BigInteger  malePartnerId;
    private BigInteger femalePartnerId;
    private int score;
    private double averageScore;
    private String club;

    public BigInteger getPairId() {
        return pairId;
    }

    public void setPairId(BigInteger pairId) {
        this.pairId = pairId;
    }

    public BigInteger getMalePartnerId() {
        return malePartnerId;
    }

    public void setMalePartnerId(BigInteger malePartnerId) {
        this.malePartnerId = malePartnerId;
    }

    public BigInteger getFemalePartnerId() {
        return femalePartnerId;
    }

    public void setFemalePartnerId(BigInteger femalePartnerId) {
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
