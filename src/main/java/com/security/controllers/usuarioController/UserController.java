package com.security.controllers.usuarioController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/login")
  public String login() {
    return "login/login";
  }
}
