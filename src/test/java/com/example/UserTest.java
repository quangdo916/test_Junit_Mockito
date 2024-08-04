package com.example;

import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@Data
public class UserTest {
  User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @Disabled
  @Test
  void testSetAge() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          user.setAge(-1);
        });
  }

  @Disabled
  @Test
  void testDoBackupTimeout(){
    assertTimeout(Duration.ofSeconds(5), () -> user.doBackup(3));
  }

  @Disabled
  @Test
  void testDoBackupTimeoutWithResult(){
    int result = assertTimeout(Duration.ofSeconds(5), () -> user.doBackUpWithResult(3));
    assertEquals(3, result);
  }
}
