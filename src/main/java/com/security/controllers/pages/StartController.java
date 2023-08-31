package com.security.controllers.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.security.service.ChamadoService;

@Controller
public class StartController {

    @Autowired
    ChamadoService chamadoService;

    @GetMapping("home")
    public ModelAndView start() {
        ModelAndView mv = new ModelAndView("home/index");
        var variavel = chamadoService
                .findAllChamados();
        mv.addObject("chamadosBanco", variavel);
        return mv;
    }

}
