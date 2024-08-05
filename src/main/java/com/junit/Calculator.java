package com.junit;

import lombok.Data;

@Data
public class Calculator {
  public int multiply(int a, int b) {
    return a * b;
  }

  public float division(float a, float b) {
    if (b == 0) {
      throw new ArithmeticException("/ by zero");
    }
    return a / b;
  }
}
