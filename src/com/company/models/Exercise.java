package com.company.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс Exercise представляет одно упражнение.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Exercise {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "reps")
    private int reps;

    public Exercise() {
    }

    public Exercise(String name, int reps) {
        this.name = name;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", reps=" + reps +
                '}';
    }
}
