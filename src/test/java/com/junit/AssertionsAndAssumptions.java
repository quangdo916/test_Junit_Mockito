package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Data
public class AssertionsAndAssumptions {
  User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  // Disable test
  @Disabled
  @Test
  void testSetAge() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          user.setAge(-1);
        });
  }

  // Timeout test
  @Disabled
  @Test
  void testDoBackupTimeout() {
    assertTimeout(Duration.ofSeconds(5), () -> user.doBackup(3));
  }

  // Timeout with result test
  @Disabled
  @Test
  void testDoBackupTimeoutWithResult() {
    int result = assertTimeout(Duration.ofSeconds(5), () -> user.doBackUpWithResult(3));
    assertEquals(3, result);
  }
}
