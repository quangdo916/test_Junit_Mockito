package com.mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.junit.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DependencyInjectionMockito {

  @Mock Database database;

  @Mock User user;

  @InjectMocks private ArticleManager manager;

  @Test
  void shouldPublishArticleWhenUserIsLoggedInAndCanPublish() {
    // Arrange
    when(user.isLoggedIn()).thenReturn(true);
    when(user.canPublish()).thenReturn(true);

    // Act
    boolean result = manager.publishArticle("Test Title", "Test Content", user);

    // Assert
    assertTrue(result);
  }

  @Test
  void shouldNotPublishArticleWhenUserIsNotLoggedIn() {
    // Arrange
    when(user.isLoggedIn()).thenReturn(false);

    // Act
    boolean result = manager.publishArticle("Test Title", "Test Content", user);

    // Assert
    assertFalse(result);
  }

  @Test
  void shouldNotPublishArticleWhenUserCannotPublish() {
    // Arrange
    when(user.isLoggedIn()).thenReturn(true);
    when(user.canPublish()).thenReturn(false);

    // Act
    boolean result = manager.publishArticle("Test Title", "Test Content", user);

    // Assert
    assertFalse(result);
  }
}
