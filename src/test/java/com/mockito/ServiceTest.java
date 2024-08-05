package com.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

  @Mock Database databaseMock;

  @Test
  void testQuery() {
    Service t = new Service(databaseMock);
    t.query("SELECT * FROM TEST");
  }
}