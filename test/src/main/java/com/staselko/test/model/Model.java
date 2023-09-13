package com.staselko.test.model;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Model implements ModelBuilder {

    @Override
    public Map<String, Long> getMap(String str) {
        return  str
                .codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
