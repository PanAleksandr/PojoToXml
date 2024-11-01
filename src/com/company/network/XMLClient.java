package com.company.network;

import com.company.models.Exercise;
import com.company.models.Sportsman;
import com.company.utils.XMLConverter;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class XMLClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);  // Sukuriame ryšį su serveriu
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // Priimame pranešimus iš serverio
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {  // Siunčiame pranešimus į serverį

            System.out.println("Prisijungta prie serverio");

            // Получение сообщений от сервера
            StringBuilder xmlData = new StringBuilder();  // Naudojame StringBuilder XML duomenims surinkti
            String line;
            boolean readingXML = false;  // Žyma, ar pradėjome skaityti XML duomenis

            while ((line = in.readLine()) != null) {
                if (line.equals("END_OF_MESSAGE")) {
                    break;  // Baigiame skaityti pranešimą pasiekę pabaigos žymą
                }
                if (line.startsWith("<?xml")) {
                    readingXML = true;  // Pradėjome skaityti XML duomenis
                }
                if (readingXML) {
                    xmlData.append(line).append("\n");  // Dedame kiekvieną eilutę į xmlData
                }
                System.out.println(line);  // Spausdiname visus serverio pranešimus (validaciją ir kt.)
            }

        } catch (Exception e) {
            e.printStackTrace();  // Spausdiname klaidą, jei atsiranda
        }
    }

}
