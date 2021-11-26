package ru.itlab.qa.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil<T> {
    ObjectMapper mapper = new ObjectMapper();

    public void writeValues(List<T> values,String path) throws IOException {
        File file = new File(path);
        System.out.println(file.createNewFile());
        mapper.writeValue(file,values);
    }
    public List<T> readValues(String path, TypeReference<List<T>> typeReference) throws IOException {
        File file = new File(path);
        return mapper.readValue(file,typeReference);
    }
}