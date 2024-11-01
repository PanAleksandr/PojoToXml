package com.company.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the Sportsman class.
 */
public class SportsmanTest {

    private Sportsman sportsman;
    private List<Exercise> exercises;

    @Before
    public void setUp() {
        // Pradinė pratimų sąrašo inicializacija
        exercises = new ArrayList<>();
        exercises.add(new Exercise("Push-up", 110));
        exercises.add(new Exercise("Squat", 20));

        // Sukuriamas naujas Sportsman objektas prieš kiekvieną testą
        sportsman = new Sportsman("John Doe", 30, exercises);
    }

    @Test
    public void testGetName() {
        // Testuojama, ar getName metodas grąžina teisingą vardą
        assertEquals("John Doe", sportsman.getName());
    }

    @Test
    public void testSetName() {
        // Testuojama, ar nustatomas naujas vardas
        sportsman.setName("Jane Doe");
        assertEquals("Jane Doe", sportsman.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameThrowsExceptionIfNameIsNull() {
        // Testuojama, ar metama išimtis, jei vardas yra null
        sportsman.setName(null);
    }

    @Test
    public void testGetAge() {
        // Testuojama, ar getAge metodas grąžina teisingą amžių
        assertEquals(30, sportsman.getAge());
    }

    @Test
    public void testSetAge() {
        // Testuojama, ar nustatomas naujas amžius
        sportsman.setAge(25);
        assertEquals(25, sportsman.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeThrowsExceptionIfAgeIsZeroOrLess() {
        // Testuojama, ar metama išimtis, jei amžius yra lygus 0 ar mažiau
        sportsman.setAge(0);
    }

    @Test
    public void testGetExercises() {
        // Testuojama, ar getExercises metodas grąžina teisingus pratimus
        assertEquals(exercises, sportsman.getExercises());
    }

    @Test
    public void testSetExercises() {
        // Sukuriami nauji pratimai ir jie nustatomi
        List<Exercise> newExercises = new ArrayList<>();
        newExercises.add(new Exercise("Deadlift", 10));
        newExercises.add(new Exercise("Bench Press", 12));

        sportsman.setExercises(newExercises);
        assertEquals(newExercises, sportsman.getExercises());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExercisesThrowsExceptionIfNull() {
        // Testuojama, ar metama išimtis, jei pratimų sąrašas yra null
        sportsman.setExercises(null);
    }

    @Test
    public void testAddExercise() {
        // Testuojama pratimų pridėjimas
        Exercise newExercise = new Exercise("Pull-up", 10);
        sportsman.addExercise(newExercise);

        assertTrue(sportsman.getExercises().contains(newExercise));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExerciseThrowsExceptionIfNull() {
        // Testuojama, ar metama išimtis, jei pridedamas pratimas yra null
        sportsman.addExercise(null);
    }

    @Test
    public void testRemoveExercise() {
        // Testuojama pratimų pašalinimas
        Exercise exerciseToRemove = exercises.get(0);
        sportsman.removeExercise(exerciseToRemove);

        assertFalse(sportsman.getExercises().contains(exerciseToRemove));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExerciseThrowsExceptionIfNull() {
        // Testuojama, ar metama išimtis, jei pašalinamas pratimas yra null
        sportsman.removeExercise(null);
    }
}
