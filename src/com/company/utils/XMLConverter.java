package com.company.utils;

import com.company.models.Sportsman;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverter {

    // objekt sportsman to xml
    public static String transformToXML(Sportsman sportsman) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Sportsman.class);
        Marshaller marshaller = context.createMarshaller();

        // grazus formotavimas
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(sportsman, writer);
        return writer.toString(); // return
    }

    //metodas convert XML lines vel i  Sportsman
    public static Sportsman transformToPOJO(String xmlData) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Sportsman.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(xmlData);
        return (Sportsman) unmarshaller.unmarshal(reader);
    }
    // metodas xml lineto filer
    public static void writeToFile(String xmlContent, String filePath) {
        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(xmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
