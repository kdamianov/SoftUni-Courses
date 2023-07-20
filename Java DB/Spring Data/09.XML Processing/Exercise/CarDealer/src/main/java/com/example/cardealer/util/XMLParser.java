package com.example.cardealer.util;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

public interface XMLParser {

    <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;
    <T> void toFile(String filePath, T entity) throws JAXBException;
}
