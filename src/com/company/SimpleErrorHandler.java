package com.company;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) {
        System.out.println("Warning: " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.out.println("Error: " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) {
        System.out.println("Fatal error: " + exception.getMessage());
    }
}
