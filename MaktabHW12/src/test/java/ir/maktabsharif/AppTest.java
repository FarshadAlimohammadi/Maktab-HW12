package ir.maktabsharif;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    HashMapImple<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new HashMapImple<>();
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
}
