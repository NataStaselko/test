package com.staselko.test;

import com.staselko.test.model.Model;
import com.staselko.test.service.StringServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class StringServiceTest {
    @Mock
    private Model model;

    @InjectMocks
    private StringServiceImpl stringService;

    @Test
    public void getMapTest(){
        String str = "bbccca";
        Map<String, Long> map = Map.of("c", 3l, "b", 2l, "a", 1l);
        when(model.getMap(str)).thenReturn(map);
        List<String> list = List.of("c: 3", "b: 2", "a: 1");
        List<String> test = stringService.getOrderDESKByFrequency(str);
        assertEquals(list, test);
    }
}
