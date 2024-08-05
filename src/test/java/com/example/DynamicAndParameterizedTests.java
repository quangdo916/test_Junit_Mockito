package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DynamicAndParameterizedTests {

  // Dynamic Test
  @TestFactory
  Stream<DynamicTest> testDifferentOperation() {
    Calculator calculator = new Calculator();
    int[][] data = new int[][] {{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
    return Arrays.stream(data)
        .map(
            entry -> {
              int m1 = entry[0];
              int m2 = entry[1];
              int expected = entry[2];
              return dynamicTest(
                  m1 + " * " + m2 + " = " + expected,
                  () -> {
                    assertEquals(expected, calculator.multiply(m1, m2));
                  });
            });
  }

  // Parameterized Test
  // 1.Data source - method
  public static int[][] data() {
    return new int[][] {{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
  }

  @ParameterizedTest
  @MethodSource(value = "data")
  void testWithStringParameter(int[] data) {
    Calculator calculator = new Calculator();
    int m1 = data[0];
    int m2 = data[1];
    int expected = data[2];
    assertEquals(expected, calculator.multiply(m1, m2));
  }

  // 2.Argument conversion
  @ParameterizedTest
  @ValueSource(ints = {1, 12, 24})
  void testWithExplicitArgumentConversion(
      @ConvertWith(ToOctalStringArgumentConverter.class) String argument) {
    System.err.println(argument);
    assertNotNull(argument);
  }

  static class ToOctalStringArgumentConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) {
      assertEquals(Integer.class, source.getClass(), "Can only convert from Integers.");
      assertEquals(String.class, targetType, "Can only convert to String");
      return Integer.toOctalString((Integer) source);
    }
  }
}
