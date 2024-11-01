package com.company;

import java.io.File;

public class FileCheck {
    public static void main(String[] args) {
        String xmlFilePath = "src/resources/sportsman.xml";
        String xsdPath = "src/resources/sportsman.xsd";
        String dtdPath = "src/resources/sportsman.dtd";


        checkFile(xmlFilePath);
        checkFile(xsdPath);
        checkFile(dtdPath);
    }

    private static void checkFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Failas Yra: " + file.getAbsolutePath() + ", dydis: " + file.length() + " B");
        } else {
            System.out.println("Error nera: " + file.getAbsolutePath());
        }
    }
}
