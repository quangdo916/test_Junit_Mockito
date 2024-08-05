package com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Configuring the return values of methods calls on the mock objects
@ExtendWith(MockitoExtension.class)
class ConfigureReturnValueMock {
  @Mock Database databaseMock;

  @Test
  void ensureMockitoReturnsTheConfiguredValue() {

    // define return value for method getUniqueId()
    when(databaseMock.getUniqueId()).thenReturn(42);

    Service service = new Service(databaseMock);
    // use mock in test....
    assertEquals(service.toString(), "Using database with id: 42");
  }

  // Test verifies that a Mockito spy on a list returns a stubbed value
  // for a specific index beyond its default range.
  @Test
  void ensureSpyForListWorks() {
    var list = new ArrayList<String>();
    var spiedList = spy(list);

    doReturn("42").when(spiedList).get(99);
    String value = (String) spiedList.get(99);

    assertEquals("42", value);
  }

  @Test
  public void testForIOException() throws IOException {
    // create an configure mock
    OutputStream mockStream = mock(OutputStream.class);
    doThrow(new IOException()).when(mockStream).close();

    // use mock
    OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);

    assertThrows(IOException.class, () -> streamWriter.close());
  }
}
