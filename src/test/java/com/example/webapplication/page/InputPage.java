package com.example.webapplication.page;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class InputPage {
  private SelenideElement inputForm = $(By.name("test-form"));

  public ResultPage submitBy(String input) {
    inputForm.find(By.name("input")).val(input).submit();
    return page(ResultPage.class);
  }
}
