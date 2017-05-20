package com.birelandef.entities;


import com.birelandef.entities.enums.ClassType;
import com.birelandef.entities.enums.SexType;
import com.birelandef.utils.IdGenerator;

import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by sophie on 14/05/17.
 */
@javax.persistence.Entity
public class Sportsmen {
    @Id
    private final String docId;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private SexType sexType;
    private ClassType latinClass;
    private ClassType standardClass;

    public Sportsmen() {
        docId  = IdGenerator.generatorId();
    }

    public Sportsmen(String docId, String firstName, String secondName, Date birthDate, SexType sexTypeType, ClassType latinClass, ClassType standardClass) {
        this.docId = docId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.sexType = sexTypeType;
        this.latinClass = latinClass;
        this.standardClass = standardClass;
    }

    public String getDocId() {
        return docId;
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

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexTypeType) {
        this.sexType = sexTypeType;
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
