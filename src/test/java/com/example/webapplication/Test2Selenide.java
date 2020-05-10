package com.example.webapplication;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Selenideを使ったテスト実行")
public class Test2Selenide {
  //System.setProperty("selenide.headless", "true");

  @DisplayName("Selenide-hello入力後にsubmit")
  @Test
  public void testSelenideA() throws InterruptedException {
    open("http://localhost:8082");

    //input画面
    $(By.name("test-form")).find(By.name("input")).val("hello").submit();

    //結果画面
    $("#result").shouldBe(text("hello2020"));
  }

  @DisplayName("Selenide-空欄入力後にsubmit")
  @Test
  public void testSelenideB() throws InterruptedException {
    open("http://localhost:8082");

    //input画面
    $(By.name("test-form")).find(By.name("input")).val("").submit();

    //結果画面
    $("#result").shouldBe(text("empty"));
  }
}
