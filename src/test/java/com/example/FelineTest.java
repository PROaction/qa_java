package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void testGetKittens() {
        int expectedKittens = 5;
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(expectedKittens);

        int actualKittens = feline.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
