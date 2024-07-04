package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static com.example.Constants.FAMALE;
import static com.example.Constants.MALE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    Feline feline;

    @ParameterizedTest
    @CsvSource({
            MALE + ", true",
            FAMALE + ", false",
            "Невалидное значение, EXCEPTION"
    })
    public void testDoesHaveMane(String sex, String expectedResult) throws Exception {
        if ("EXCEPTION".equals(expectedResult)) {
            Exception exception = assertThrows(Exception.class, () -> new  Lion(feline, sex));
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
        else {
            boolean expectedBool = Boolean.parseBoolean(expectedResult);
            Lion lion = new Lion(feline, sex);
            assertEquals(expectedBool, lion.doesHaveMane());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, MALE);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, FAMALE);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
