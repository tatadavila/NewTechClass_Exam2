package com.edu.uac.co.newtech_exam2;

import java.io.Serializable;

public class User implements Serializable {

    public String id;
    public String name;
    public String stratum;
    public String wage;
    public String educationLevel;

    public User(String id, String name, String stratum, String wage, String educationLevel) {
        this.id = id;
        this.name = name;
        this.stratum = stratum;
        this.wage = wage;
        this.educationLevel = educationLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStratum() {
        return stratum;
    }

    public void setStratum(String stratum) {
        this.stratum = stratum;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }


}
