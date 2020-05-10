package com.example.webapplication.page;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
  private SelenideElement result = $("#result");

  public SelenideElement text() {
    return result;
  }
}
