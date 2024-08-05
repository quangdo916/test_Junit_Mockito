package com.mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Creating mock objects with the Mockito API
@ExtendWith(MockitoExtension.class)
class Overview {

  @Mock Database databaseMock;

  @Test
  public void testQuery() {
    assertNotNull(databaseMock);
    when(databaseMock.isAvailable()).thenReturn(true);
    Service t = new Service(databaseMock);
    boolean check = t.query("* from t");
    assertTrue(check);
  }
}
