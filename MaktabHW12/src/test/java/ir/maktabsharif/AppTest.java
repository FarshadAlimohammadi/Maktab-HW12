package ir.maktabsharif;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.UserDAO;
import ir.maktabsharif.service.SecurityService;
import ir.maktabsharif.service.UserServiceImple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AppTest {
    static HashMapImple<Integer, String> map;
    static Number number;

    static UserServiceImple userServiceImple;

    static User user;

    @Mock
    SecurityService securityService;

    @Mock
    UserDAO userDAO;

    @BeforeAll
    static void setUp() {
        map = new HashMapImple<>();
        number = new Number();
        user = new User();
    }

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
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

    @Test
    @DisplayName("User Password")
    void testSetUserPassword() throws Exception {
        userServiceImple = new UserServiceImple(userDAO, securityService);

        User user = new User("farshad", "alimohammadi", 22, "555");

        String expected = "de3hj";

        when(securityService.md5("555")).thenReturn(expected);

        userServiceImple.assignPassword(user);

        assertEquals(expected, user.getPassword());

        verify(securityService, times(1)).md5("555");
    }
}
