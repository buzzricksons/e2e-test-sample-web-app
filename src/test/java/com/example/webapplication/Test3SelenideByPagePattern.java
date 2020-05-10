package com.example.webapplication;

import com.example.webapplication.page.InputPage;
import com.example.webapplication.page.ResultPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Selenideを使ったテスト実行")
public class Test3SelenideByPagePattern {
  //System.setProperty("selenide.headless", "true");

  @DisplayName("Selenide-hello入力後にsubmit")
  @Test
  public void testSelenideA() throws InterruptedException {
    InputPage inputPage = open("http://localhost:8082", InputPage.class);
    ResultPage resultPage = inputPage.submitBy("hello");

    resultPage.text().shouldBe(text("hello2020"));
  }

  @DisplayName("Selenide-空欄入力後にsubmit")
  @Test
  public void testSelenideB() throws InterruptedException {
    InputPage inputPage = open("http://localhost:8082", InputPage.class);
    ResultPage resultPage = inputPage.submitBy("");

    resultPage.text().shouldBe(text("empty"));
  }
}
