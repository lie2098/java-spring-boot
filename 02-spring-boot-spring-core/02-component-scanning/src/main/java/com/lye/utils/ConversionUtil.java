package com.lye.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class ConversionUtil {
    public Object stringToObject(String text, String delimiter) {
        List<String> textList = Arrays.asList(text.split(delimiter));
        Map<String, String> object = new HashMap<>();

        IntStream.range(0, textList.size()).forEach(index -> {
            object.put(String.valueOf(index), textList.get(index));
        });

        return object;
    }
}
