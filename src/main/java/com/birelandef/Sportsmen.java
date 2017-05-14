package com.birelandef;


import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by sophie on 14/05/17.
 */
@javax.persistence.Entity
public class Sportsmen {
    @Id
    private BigInteger docId;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private Sex sexType;
    private ClassType latinClass;
    private ClassType standardClass;

    public Sportsmen() {
    }

    public BigInteger getDocId() {
        return docId;
    }
    public void setDocId(BigInteger docId) {
        this.docId = docId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSexType() {
        return sexType;
    }

    public void setSexType(Sex sexType) {
        this.sexType = sexType;
    }

    public ClassType getLatinClass() {
        return latinClass;
    }

    public void setLatinClass(ClassType latinClass) {
        this.latinClass = latinClass;
    }

    public ClassType getStandardClass() {
        return standardClass;
    }

    public void setStandardClass(ClassType standardClass) {
        this.standardClass = standardClass;
    }

    @Override
    public String toString() {
        return "Sportsmen{" +
                "docId=" + docId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDate=" + birthDate +
                ", sexType=" + sexType +
                ", latinClass=" + latinClass +
                ", standardClass=" + standardClass +
                '}';
    }
}
