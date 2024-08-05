package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseTest {
    ExerciseClass tester;

    @BeforeEach
    public void setup(){
        tester = new ExerciseClass();
    }

    @Test
    void testExceptionIsThrown(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> tester.multiply(1000, 5));
        assertEquals("X should be less than 1000", exception.getMessage());
    }

    @Test
    void testMultiply(){
        assertEquals(50, tester.multiply(10, 5));
    }
}
