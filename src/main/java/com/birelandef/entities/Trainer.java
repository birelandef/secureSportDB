package com.birelandef.entities;

import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.ProgramType;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.competition", cascade=CascadeType.ALL)
    private Set<CompetitionResult> results;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Trains",
            joinColumns = @JoinColumn(name = "tDocId"),
            inverseJoinColumns = @JoinColumn(name = "pairId"))
    private List<Pair> trainedPairs;

    public Set<CompetitionResult> getResults() {
        return results;
    }

    public void setResults(Set<CompetitionResult> results) {
        this.results = results;
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
}
