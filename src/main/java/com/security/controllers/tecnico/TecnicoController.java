package com.security.controllers.tecnico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.security.Enum.Perfil;
import com.security.model.Tecnico;
import com.security.repository.TecnicoRepository;
import com.security.service.HomeService;
import com.security.util.PasswordUtil;
import com.security.util.UploadUtil;

@Controller
@RequestMapping("tecnico")
public class TecnicoController {

  @Autowired
  private HomeService homeService;
  @Autowired
  private TecnicoRepository tecnicoRepository;

  @GetMapping("cadastro")
  public ModelAndView cadastro(Tecnico tecnico) {
    ModelAndView mv = new ModelAndView("/tecnico/cadastro");
    mv.addObject("tecnico", tecnico);
    mv.addObject("perfils", Perfil.values());
    return mv;
  }

  @GetMapping(value = "list-tecnicos")
  public ModelAndView tecnicosList() {
    ModelAndView mv = new ModelAndView("tecnico/tecnico-list");
    mv.addObject("tecnicos", tecnicoRepository.findAll());
    return mv;
  }

  @PostMapping("cadastro-tecnico")
  public ModelAndView cadastro(@ModelAttribute Tecnico tecnico, @RequestParam("file") MultipartFile imagem) {
    ModelAndView mv = new ModelAndView("tecnico/cadastro");
    String hashSenha = PasswordUtil.encoder(tecnico.getSenha());
    tecnico.setSenha(hashSenha);
    mv.addObject("tecnico", tecnico);
    try {
      if (UploadUtil.fazerUploading(imagem)) {
        tecnico.setImagem(imagem.getOriginalFilename());
      }
      tecnicoRepository.save(tecnico);
      System.out.println("Salvo com sucesso " + tecnico.getNome() + " " + tecnico.getImagem());
      return homeService.getHome();
    } catch (Exception e) {
      mv.addObject("msgErro", e.getMessage());
      System.out.println("Erro ao salvar" + e.getMessage());
      return mv;
    }
  }

  @GetMapping("excluir/{id}")
  public ModelAndView excluirTecnico(@PathVariable("id") Integer id) {
    tecnicoRepository.deleteById(id);
    return homeService.getHome();
  }

  @GetMapping("editar/{id}")
  public ModelAndView editarTecnico(@PathVariable("id") Integer id) {
    ModelAndView mv = new ModelAndView("tecnico/editar-tecnico");
    mv.addObject("tecnico", tecnicoRepository.findById(id));
    mv.addObject("perfils", Perfil.values());
    return mv;
  }

  @PostMapping("editar-tecnico")
  public ModelAndView editarT(Tecnico tecnico) {
    tecnicoRepository.save(tecnico);
    return tecnicosList();
  }
}
