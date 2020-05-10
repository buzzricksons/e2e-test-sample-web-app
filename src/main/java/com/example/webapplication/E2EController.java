package com.example.webapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class E2EController {

  @PostMapping("/e2e")
  public String greeting(Name name, Model model) {
    model.addAttribute("result", name.getInput() + "2020");
    return "e2e";
  }

}
