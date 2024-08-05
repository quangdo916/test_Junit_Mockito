package com.mockito;

import com.junit.User;

public class ArticleManager {
  private Database database;

  public ArticleManager(Database database) {
    this.database = database;
  }

  public boolean publishArticle(String title, String content, User user) {
    return false;
  }
}
