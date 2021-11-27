package ru.itlab.qa.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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

    public String generateString(int length){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

}