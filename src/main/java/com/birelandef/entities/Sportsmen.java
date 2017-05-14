package com.birelandef.entities;


import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;

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
    private SexType sexTypeType;
    private ClassType latinClass;
    private ClassType standardClass;

    public Sportsmen() {
    }

    public Sportsmen(BigInteger docId, String firstName, String secondName, Date birthDate, SexType sexTypeType, ClassType latinClass, ClassType standardClass) {
        this.docId = docId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.sexTypeType = sexTypeType;
        this.latinClass = latinClass;
        this.standardClass = standardClass;
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

    public SexType getSexTypeType() {
        return sexTypeType;
    }

    public void setSexTypeType(SexType sexTypeType) {
        this.sexTypeType = sexTypeType;
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
                ", sexTypeType=" + sexTypeType +
                ", latinClass=" + latinClass +
                ", standardClass=" + standardClass +
                '}';
    }
}
