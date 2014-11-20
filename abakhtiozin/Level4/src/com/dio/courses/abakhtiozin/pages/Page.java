package com.dio.courses.abakhtiozin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

  public WebDriver driver;
  
  public boolean isOnThisPage() {
    return true;
  }

  abstract void tryToOpen();

  public WebDriverWait webDriverWait() {
    return new WebDriverWait(driver, 10);
  }
}
