package com.jvgroup.jvchatapp.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Converter(autoApply = true)
public class ArrayStringListConverter implements AttributeConverter<List<String>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting list to JSON string", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String jsonString) {
        if (jsonString == null) {
            return new ArrayList<>();
        }
        try {
            // Read JSON array into List<String>
            return objectMapper.readValue(jsonString, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            // Log the error and the problematic JSON string
            System.err.println("Error converting JSON string to list: " + jsonString);
            e.printStackTrace();
            throw new IllegalArgumentException("Error converting JSON string to list", e);
        }
    }
}