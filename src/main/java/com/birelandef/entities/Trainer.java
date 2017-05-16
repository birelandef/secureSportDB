package com.birelandef.entities;

import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by sophie on 15/05/17.
 */
public class Trainer {
    @Id
    private String tDocId;
    private String lastName;
    private String firstName;
    private String club;
    private boolean isLatin;
    private boolean isStandard;

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
