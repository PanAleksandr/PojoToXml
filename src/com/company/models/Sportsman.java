package com.company.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.ArrayList;

/**
 * Class Sportsman represents an athlete with their exercises.
 */
// Klasė Sportsman reprezentuoja sportininką su jo pratimais.
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sportsman {

    private String name; // Sportininko vardas
    private int age; // Sportininko amžius

    @XmlElementWrapper(name = "exercises") // Anotacija, nurodanti, kad pratimai turi būti apvynioti žyme <exercises>
    @XmlElement(name = "exercise") // Nurodo, kad kiekvienas pratimas bus pažymėtas kaip <exercise>
    private List<Exercise> exercises; // Pratimų sąrašas

    /**
     * Default constructor required for JAXB.
     */
    // Numatytasis konstruktorius, reikalingas JAXB.
    public Sportsman() {
        this.exercises = new ArrayList<>(); // Inicializuojame tuščią pratimų sąrašą
    }

    /**
     * Constructor with parameters.
     *
     * @param name      athlete's name
     * @param age       athlete's age
     * @param exercises athlete's list of exercises
     * @throws IllegalArgumentException if the input values are invalid
     */
    // Konstruktorius su parametrais, kuris inicializuoja sportininką ir jo pratimus
    public Sportsman(String name, int age, List<Exercise> exercises) {
        if (name == null || name.trim().isEmpty()) { // Patikriname, ar vardas nėra tuščias arba null
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        if (age <= 0) { // Patikriname, ar amžius yra teigiamas skaičius
            throw new IllegalArgumentException("Age must be positive");
        }
        if (exercises == null) { // Patikriname, ar pratimų sąrašas nėra null
            throw new IllegalArgumentException("Exercises cannot be null");
        }
        this.name = name; // Priskiriame vardą
        this.age = age; // Priskiriame amžių
        this.exercises = new ArrayList<>(exercises); // Kopijuojame pratimų sąrašą
    }

    /**
     * Returns the athlete's name.
     *
     * @return athlete's name
     */
    // Grąžina sportininko vardą
    public String getName() {
        return name;
    }

    /**
     * Sets the athlete's name.
     *
     * @param name new name of the athlete
     * @throws IllegalArgumentException if the name is empty or null
     */
    // Nustato sportininko vardą
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) { // Patikriname, ar vardas nėra tuščias arba null
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name; // Priskiriame naują vardą
    }

    /**
     * Returns the athlete's age.
     *
     * @return athlete's age
     */
    // Grąžina sportininko amžių
    public int getAge() {
        return age;
    }

    /**
     * Sets the athlete's age.
     *
     * @param age new age of the athlete
     * @throws IllegalArgumentException if the age is less than or equal to 0
     */
    // Nustato sportininko amžių
    public void setAge(int age) {
        if (age <= 0) { // Patikriname, ar amžius nėra mažesnis arba lygus nuliui
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age; // Priskiriame naują amžių
    }

    /**
     * Returns the list of athlete's exercises.
     *
     * @return immutable list of exercises
     */
    // Grąžina sportininko pratimų sąrašą
    public List<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Sets the list of athlete's exercises.
     *
     * @param exercises new list of exercises
     * @throws IllegalArgumentException if the list is null
     */
    // Nustato sportininko pratimų sąrašą
    public void setExercises(List<Exercise> exercises) {
        if (exercises == null) { // Patikriname, ar pratimų sąrašas nėra null
            throw new IllegalArgumentException("Exercises cannot be null");
        }
        this.exercises.clear(); // Išvalome dabartinį pratimų sąrašą
        this.exercises.addAll(exercises); // Pridedame naujus pratimus į sąrašą
    }

    /**
     * Adds an exercise to the athlete.
     *
     * @param exercise new exercise
     * @throws IllegalArgumentException if the exercise is null
     */
    // Prideda naują pratimą į sportininko sąrašą
    public void addExercise(Exercise exercise) {
        if (exercise == null) { // Patikriname, ar pratimas nėra null
            throw new IllegalArgumentException("Exercise cannot be null");
        }
        exercises.add(exercise); // Pridedame pratimą į sąrašą
    }

    /**
     * Removes an exercise from the athlete's list.
     *
     * @param exercise exercise to be removed
     * @throws IllegalArgumentException if the exercise is null
     */
    // Pašalina pratimą iš sportininko pratimų sąrašo
    public void removeExercise(Exercise exercise) {
        if (exercise == null) { // Patikriname, ar pratimas nėra null
            throw new IllegalArgumentException("Exercise cannot be null");
        }
        exercises.remove(exercise); // Pašaliname pratimą iš sąrašo
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", exercises=" + exercises +
                '}';
    }
    // Grąžina sportininko duomenis kaip eilutę
}
