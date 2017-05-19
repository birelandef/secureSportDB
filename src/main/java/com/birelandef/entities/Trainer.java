package com.birelandef.entities;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sophie on 15/05/17.
 */
@Entity
public class Trainer {
    @Id
    private String tDocId;
    private String lastName;
    private String firstName;
    private String club;
    private boolean isLatin;
    private boolean isStandard;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.competition", cascade=CascadeType.MERGE)
    private Set<CompetitionSettings> judgingCompetitions;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "Trains",
            joinColumns = @JoinColumn(name = "tDocId", updatable = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name = "pairId", updatable = false, nullable = false))
    private List<Pair> trainedPairs;


    public  void selectAndSaveTrainingPairs(int selectedCount, List<Pair> pairs) {
        Set<Pair> selectedPairs = new HashSet<>();

        Random random = new Random();
        for (int i = 0; i < selectedCount; i++) {
            Pair pair = pairs.get(random.nextInt(pairs.size()));
            if ((this.isStandard) &&
                    (pair.getFemalePartnerId().getStandardClass() != null) &&
                    (pair.getMalePartnerId().getStandardClass() != null)) {
                selectedPairs.add(pair);
            }
            if ((this.isLatin) &&
                    (pair.getFemalePartnerId().getLatinClass() != null) &&
                    (pair.getMalePartnerId().getLatinClass() != null)) {
                selectedPairs.add(pair);
            }
        }
        trainedPairs =  selectedPairs.stream().collect(Collectors.toList());
    }



    public List<Pair> getTrainedPairs() {
        return trainedPairs;
    }

    public void setTrainedPairs(List<Pair> trainedPairs) {
        this.trainedPairs = trainedPairs;
    }

    public Set<CompetitionSettings> getJudgingCompetitions() {
        return judgingCompetitions;
    }

    public void setJudgingCompetitions(Set<CompetitionSettings> results) {
        this.judgingCompetitions = results;
    }

    public Trainer() {
    }

    public String gettDocId() {
        return tDocId;
    }


    public void settDocId(String tDocId) {
        this.tDocId = tDocId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public boolean isLatin() {
        return isLatin;
    }

    public void setLatin(boolean latin) {
        isLatin = latin;
    }

    public boolean isStandard() {
        return isStandard;
    }

    public void setStandard(boolean standard) {
        isStandard = standard;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "tDocId=" + tDocId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", club='" + club + '\'' +
                ", isLatin=" + isLatin +
                ", isStandard=" + isStandard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer trainer = (Trainer) o;

        if (isLatin != trainer.isLatin) return false;
        if (isStandard != trainer.isStandard) return false;
        if (!tDocId.equals(trainer.tDocId)) return false;
        if (lastName != null ? !lastName.equals(trainer.lastName) : trainer.lastName != null) return false;
        if (firstName != null ? !firstName.equals(trainer.firstName) : trainer.firstName != null) return false;
        if (club != null ? !club.equals(trainer.club) : trainer.club != null) return false;
        if (judgingCompetitions != null ? !judgingCompetitions.equals(trainer.judgingCompetitions) : trainer.judgingCompetitions != null) return false;
        return trainedPairs != null ? trainedPairs.equals(trainer.trainedPairs) : trainer.trainedPairs == null;

    }

    @Override
    public int hashCode() {
        int result = tDocId.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (club != null ? club.hashCode() : 0);
        result = 31 * result + (isLatin ? 1 : 0);
        result = 31 * result + (isStandard ? 1 : 0);
        result = 31 * result + (judgingCompetitions != null ? judgingCompetitions.hashCode() : 0);
        result = 31 * result + (trainedPairs != null ? trainedPairs.hashCode() : 0);
        return result;
    }
}
