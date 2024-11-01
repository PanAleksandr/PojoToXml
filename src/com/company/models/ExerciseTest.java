package com.company.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseTest {

    private Exercise exercise;

    @Before
    public void setUp() {
        // Инициализация перед каждым тестом
        // Inicializacija prieš kiekvieną testą
        exercise = new Exercise("Push-up", 15);
    }

    @Test
    public void testGetName() {
        // Проверка, что метод getName() возвращает правильное имя
        // Tikriname, ar metodas getName() grąžina teisingą pavadinimą
        assertEquals("Push-up", exercise.getName());
    }

    @Test
    public void testGetRepetitions() {
        // Проверка, что метод getRepetitions() возвращает правильное количество повторений
        // Tikriname, ar metodas getRepetitions() grąžina teisingą kartojimų skaičių
        assertEquals(15, exercise.getReps());
    }

    @Test
    public void testSetName() {
        // Изменение имени и проверка нового значения
        // Pakeičiame pavadinimą ir tikriname naują vertę
        exercise.setName("Pull-up");
        assertEquals("Pull-up", exercise.getName());
    }

    @Test
    public void testSetRepetitions() {
        // Изменение количества повторений и проверка нового значения
        // Pakeičiame kartojimų skaičių ir tikriname naują vertę
        exercise.setReps(20);
        assertEquals(20, exercise.getReps());
    }
}
