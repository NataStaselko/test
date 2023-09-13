package com.staselko.test;

import com.staselko.test.service.StringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StringService stringService;

    @Test
    void getAnswerTest() throws Exception {
        String str = "abbccc";
        mockMvc.perform(get("/test").param("text", str))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").value("c: 3"))
                .andExpect(jsonPath("$[1]").value("b: 2"))
                .andExpect(jsonPath("$[2]").value("a: 1"));
    }

    @Test
    void getExceptionTest() throws Exception {
        String str = "шшшшш";
        mockMvc.perform(get("/test").param("text", str))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("getAnswer.text: Incorrect text"));
    }

}
