package com.staselko.test.service;

import com.staselko.test.model.ModelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StringServiceImpl implements StringService {
    private final ModelBuilder model;

    @Override
    public List<String> getOrderDESKByFrequency(String str) {
        return model.getMap(str)
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .toList();
    }
}
