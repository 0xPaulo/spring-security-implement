package com.security.controllers.chamado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.security.Enum.Prioridade;
import com.security.Enum.StatusChamado;
import com.security.model.Chamado;
import com.security.repository.ChamadoRepository;
import com.security.repository.TecnicoRepository;
import com.security.service.HomeService;

@Controller
@RequestMapping("chamado")
public class chamadoController {

  @Autowired
  private HomeService homeService;
  @Autowired
  private TecnicoRepository tecnicoRepository;
  @Autowired
  private ChamadoRepository chamadoRepository;

  @GetMapping("criar")
  public ModelAndView criarChamado(Chamado chamado) {
    ModelAndView mv = new ModelAndView("chamado/ticket");
    mv.addObject("statusChamado", StatusChamado.values());
    mv.addObject("Prioridade", Prioridade.values());
    mv.addObject("tecnicos", tecnicoRepository.findAll());
    mv.addObject("chamado", chamado);
    return mv;
  }

  @PostMapping("newTask")
  public ModelAndView novoChamado(Chamado chamado) {
    chamadoRepository.save(chamado);
    return homeService.getHome();

  }

}
