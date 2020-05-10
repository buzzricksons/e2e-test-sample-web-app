package com.example.webapplication;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Seleniumを使ったテスト実行")
public class Test1Selenium {
  private static WebDriver driver;

  @BeforeAll
  public static void setUp(){
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    driver = new ChromeDriver();
  }

  @DisplayName("Selenium-hello入力後にsubmit")
  @Test
  public void testSeleniumA() throws InterruptedException {
    driver.get("http://localhost:8082");
    Thread.sleep(4000);  // Let the user actually see something!

    //input画面
    WebElement inputForm = driver.findElement(By.name("test-form"));
    inputForm.findElement(By.name("input")).sendKeys("hello");
    Thread.sleep(4000);  // Let the user actually see something!
    inputForm.submit();

    //結果画面
    Thread.sleep(4000);  // Let the user actually see something!
    String resultPageText = driver.findElement(By.id("result")).getText();

    Assertions.assertEquals("hello2020", resultPageText);
  }

  @DisplayName("Selenium-空欄入力後にsubmit")
  @Test
  public void testSeleniumB() throws InterruptedException {
    driver.get("http://localhost:8082");
    Thread.sleep(4000);  // Let the user actually see something!

    //input画面
    WebElement inputForm = driver.findElement(By.name("test-form"));
    inputForm.findElement(By.name("input")).sendKeys("");
    Thread.sleep(4000);  // Let the user actually see something!
    inputForm.submit();

    //結果画面
    Thread.sleep(4000);  // Let the user actually see something!
    String resultPageText = driver.findElement(By.id("result")).getText();

    Assertions.assertEquals("empty", resultPageText);
  }

  @AfterAll
  public static void cleanUp(){
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}
