package com.security.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HomeService {

  public ModelAndView getHome() {
    ModelAndView mv = new ModelAndView("home/index");
    return mv;
  }
}
