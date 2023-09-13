package com.staselko.test;
import com.staselko.test.model.Model;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {

     @Test
    public  void  getMapTest(){
         Model model = new Model();
         String str = "bbccca";
         Map<String, Long> map = Map.of("b", 2l, "c", 3l, "a", 1l);
         Map<String, Long> test = model.getMap(str);
         assertEquals(map, test);
     }
}
