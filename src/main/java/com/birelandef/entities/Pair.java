package com.birelandef.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.competition", cascade=CascadeType.MERGE)
    private Set<CompetitionResult> competitionResults;

//    public  void selectAndSaveCompetitions(int selectedCount, List<Competition> allCompetitions) {
//        Set<Competition> selectedCompetitions = new HashSet<>();
//
//        Random random = new Random();
//        for (int i = 0; i < selectedCount; i++) {
//            Competition competition = allCompetitions.get(random.nextInt(allCompetitions.size()));
//                selectedCompetitions.add(competition);
//            }
//        competitions =  selectedCompetitions.stream().collect(Collectors.toList());
//    }


    public Set<CompetitionResult> getCompetitionResults() {
        return competitionResults;
    }

    public void setCompetitionResults(Set<CompetitionResult> competitionResults) {
        this.competitionResults = competitionResults;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (score != pair.score) return false;
        if (Double.compare(pair.averageScore, averageScore) != 0) return false;
        if (!pairId.equals(pair.pairId)) return false;
        if (!malePartnerId.equals(pair.malePartnerId)) return false;
        if (!femalePartnerId.equals(pair.femalePartnerId)) return false;
        if (club != null ? !club.equals(pair.club) : pair.club != null) return false;
        return competitionResults != null ? competitionResults.equals(pair.competitionResults) : pair.competitionResults == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = pairId.hashCode();
        result = 31 * result + malePartnerId.hashCode();
        result = 31 * result + femalePartnerId.hashCode();
        result = 31 * result + score;
        temp = Double.doubleToLongBits(averageScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (club != null ? club.hashCode() : 0);
        result = 31 * result + (competitionResults != null ? competitionResults.hashCode() : 0);
        return result;
    }
}
