package com.company.utils;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.company.SimpleErrorHandler;
import org.w3c.dom.Document;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Paths;

public class XMLValidator {

    // validacija XSD
    public static boolean validateXMLSchema(String xsdPath, String xmlData) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(new File(xsdPath)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlData)));
            return true;
        } catch (Exception e) {
            System.out.println("Error validator pagal XSD: " + e.getMessage());
            return false;
        }
    }

    // validacija po DTD
    public static boolean validateXMLWithDTD(String dtdPath, String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // Включаем валидацию
            factory.setNamespaceAware(true); // Поддержка пространств имен

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());

            // Чтение XML документа
            Document document = builder.parse(Paths.get(xmlFilePath).toFile());
            return true;
        } catch (Exception e) {
            System.out.println("Error validator XML pagal DTD: " + e.getMessage());
            return false;
        }
    }
}
