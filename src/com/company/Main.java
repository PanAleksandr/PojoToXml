package com.company;

import com.company.models.Exercise;
import com.company.models.Sportsman;
import com.company.utils.XMLConverter;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем список упражнений
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Running", 5));
        exercises.add(new Exercise("Swimming", 20));
        exercises.add(new Exercise("Cycling", 30));
        exercises.add(new Exercise("Push-ups", 15));
        exercises.add(new Exercise("Pull-ups", 10));
        exercises.add(new Exercise("Squats", 20));
        exercises.add(new Exercise("Deadlift", 12));
        exercises.add(new Exercise("Bench Press", 8));
        exercises.add(new Exercise("Plank", 2));
        exercises.add(new Exercise("Burpees", 25));

        // Создаем объект Sportsman с новыми данными
        Sportsman sportsman = new Sportsman("Brius Li", 290, exercises);

        // Указываем путь для сохранения XML-файла
        String xmlFilePath = "src/resources/sportsman_output.xml";

        try {
            // Конвертируем объект Sportsman в XML и сохраняем в файл
            String sportsmanXML = XMLConverter.transformToXML(sportsman);
            XMLConverter.writeToFile(sportsmanXML, xmlFilePath);
            System.out.println("XML failas sukurtas ir issaugotas: " + xmlFilePath);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
