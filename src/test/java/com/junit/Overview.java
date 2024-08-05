package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class Overview {
  Calculator calculator;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator();
  }

  // Standard test
  @Test
  @DisplayName("Multiplication test")
  public void testMultiply() {
    assertEquals(50, calculator.multiply(10, 5), "10 * 5 must be 50");
  }

  // Exception test
  @Test
  @DisplayName("Exception test")
  public void exceptionTesting() {
    Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.division(10, 0));
    assertEquals("/ by zero", exception.getMessage());
  }

  // Group test
  @Test
  public void groupAssertion() {
    assertAll(
        "Arithmetic operation",
        () -> assertEquals(50, calculator.multiply(5, 10)),
        () -> assertThrows(ArithmeticException.class, () -> calculator.division(10, 0)));
  }

  // Repeated test
  @RepeatedTest(5)
  @DisplayName("Repeated multiplication test")
  public void testMultiplyRepeated() {
    assertEquals(50, calculator.multiply(10, 5), "0 * 5 must be 0");
    assertEquals(50, calculator.multiply(5, 10), "0 * 5 must be 0");
  }
}
