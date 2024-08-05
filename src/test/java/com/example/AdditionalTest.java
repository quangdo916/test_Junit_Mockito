package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalTest {
  Calculator calculator = new Calculator();
  User user = new User();

  // Test execution order
  @Test
  @Order(2)
  public void testMultiply() {
    System.err.println("Running testMultiply()");
    assertEquals(50, calculator.multiply(10, 5), "10 * 5 must be 50");
  }

  @Test
  @Order(1)
  void testSetAge() {
    System.err.println("Running testSetAge()");
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          user.setAge(-1);
        });
  }

  // Using the @TempDir annotation to create temporary files and paths
  @Test
  @DisplayName(
      "Ensure that two temporary directories with same files names and content have same hash")
  void hashTwoDynamicDirectoryWhichHaveSameContent(@TempDir Path tempDir, @TempDir Path tempDir2)
      throws IOException {

    Path file1 = tempDir.resolve("myfile.txt");
    System.err.println(file1.toAbsolutePath().toString());

    List<String> input = Arrays.asList("input1", "input2", "input3");
    Files.write(file1, input);

    assertTrue(Files.exists(file1), "File should exist");

    Path file2 = tempDir2.resolve("myfile.txt");

    Files.write(file2, input);
    assertTrue(Files.exists(file2), "File should exist");
  }
}
