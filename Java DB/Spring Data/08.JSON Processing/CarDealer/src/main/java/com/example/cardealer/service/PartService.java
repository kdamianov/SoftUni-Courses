package com.example.cardealer.service;

import com.example.cardealer.model.entities.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {
    void seedParts() throws IOException;

    Set<Part> findRandomPart();
}
