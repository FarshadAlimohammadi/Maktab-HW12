package ir.maktabsharif;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    static HashMapImple<Integer, String> map;
    static Number number;

    @BeforeAll
    static void setUp() {
        map = new HashMapImple<>();
        number = new Number();
    }

    @Test
    @DisplayName("put and get")
    void testPutAndGet(){
        assertEquals(map.get(1), map.put(1, "farshad"));
    }

    @Test
    @DisplayName("adding second object")
    void testAddingSecondObject(){
        assertEquals(map.get(1), map.put(1, "ali"));
    }

    @Test
    @DisplayName("clear method")
    void testClearMethod(){
        map.clear();
        assertEquals(true,map.isEmpty());
    }

    @Test
    @DisplayName("null value as a key")
    void testNullValueAsAKey(){
        assertEquals(map.get(null), map.put(null, "reza"));
    }

    @Test
    @DisplayName("Numbers of 3 digits or more")
    void testNumberOfThreeDigitsOrMore(){
        List<Integer> list = new ArrayList<>();
        list.add(345);
        list.add(678);
        assertEquals(list,number.Computing("cdefg 345 12bbb33 678tt"));
    }
}
