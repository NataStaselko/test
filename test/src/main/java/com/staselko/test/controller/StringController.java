package com.staselko.test.controller;

import com.staselko.test.service.StringService;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/test")
@RequiredArgsConstructor
public class StringController {
    private final StringService stringService;

    @GetMapping
    public ResponseEntity<List<String>> getAnswer(@RequestParam (value = "text")
                                                  @Size(min = 1, max = 100, message = "The text contains 0 to 100 characters")
                                                  @Pattern(regexp = "[a-zA-Z\\s\\d~.\"(),:;<>@\\[\\]!#$%&'*+-/=?^_`{|}]*", message = "Incorrect text")
                                                  String text){
        return ResponseEntity.ok(stringService.getOrderDESKByFrequency(text));
    }
}
