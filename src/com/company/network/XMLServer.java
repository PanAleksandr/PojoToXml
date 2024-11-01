package com.company.network;

import com.company.models.Exercise;
import com.company.models.Sportsman;
import com.company.utils.XMLConverter;
import com.company.utils.XMLValidator;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLServer {

    public static void main(String[] args) {
        String xmlFilePath = "src/resources/sportsman2.xml";  // XML failas su DTD
        String xsdFilePath = "src/resources/sportsman.xsd";  // XSD schema
        String dtdFilePath = "src/resources/sportsman.dtd";  // DTD failas

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Serveris veikia ir laukia prisijungimų...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                    // Skaitome XML duomenis iš failo
                    String xmlData = new String(Files.readAllBytes(Paths.get(xmlFilePath)));

                    // XSD validacija
                    boolean isValidXSD = XMLValidator.validateXMLSchema(xsdFilePath, xmlData);
                    String xsdValidationMessage = isValidXSD ? "XML yra teisingas pagal XSD." : "XML nėra teisingas pagal XSD.";

                    // DTD validacija
                    boolean isValidDTD = XMLValidator.validateXMLWithDTD(dtdFilePath, xmlFilePath);
                    String dtdValidationMessage = isValidDTD ? "XML yra teisingas pagal DTD." : "XML nėra teisingas pagal DTD.";

                    // Siunčiame validacijos rezultatus klientui
                    out.write(xsdValidationMessage + "\n");
                    out.write(dtdValidationMessage + "\n");

                    // Jei abu validacijos testai praėjo sėkmingai, siunčiame dekoduotus duomenis
                    if (isValidXSD && isValidDTD) {
                        Sportsman sportsman = XMLConverter.transformToPOJO(xmlData); // Konvertuojame XML į objektą
                        String sportsmanXML = XMLConverter.transformToXML(sportsman);  // Konvertuojame objektą į XML

                        // Siunčiame XML klientui
                        out.write("=== Dekoduotas sportininkas ===\n");
                        out.write(sportsmanXML + "\n");

                        // Siunčiame duomenis žmonių suprantamu formatu
                        out.write("=== Žmonėms suprantamas formatas ===\n");
                        out.write("Vardas: " + sportsman.getName() + "\n");
                        out.write("Amžius: " + sportsman.getAge() + "\n");
                        out.write("Pratimai:\n");
                        for (Exercise exercise : sportsman.getExercises()) {
                            out.write(" - Pratimas: " + exercise.getName() + ", pakartojimų skaičius: " + exercise.getReps() + "\n");
                        }
                    }

                    out.write("END_OF_MESSAGE\n");  // Pridedame pranešimo pabaigą
                    out.flush();
                    System.out.println("Duomenys išsiųsti klientui.");
                } catch (IOException | JAXBException e) {
                    e.printStackTrace();  // Spausdiname klaidas, jei tokių yra
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  // Spausdiname klaidas, jei tokių yra
        }
    }
}
