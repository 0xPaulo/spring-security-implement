package com.security.controllers.cliente;

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
import com.security.model.Cliente;
import com.security.repository.ClienteRepository;
import com.security.service.HomeService;
import com.security.util.PasswordUtil;
import com.security.util.UploadUtil;

@Controller
@RequestMapping("cliente")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private HomeService homeService;

  @GetMapping("cadastro")
  public ModelAndView cadastro(Cliente cliente) {
    ModelAndView mv = new ModelAndView("/cliente/cadastro");
    mv.addObject("usuario", new Cliente());
    mv.addObject("perfils", Perfil.values());
    return mv;
  }

  @PostMapping("cadastro-cliente")
  public ModelAndView cadastro(@ModelAttribute Cliente cliente, @RequestParam("file") MultipartFile imagem) {
    ModelAndView mv = new ModelAndView("cliente/cadastro");
    String hashSenha = PasswordUtil.encoder(cliente.getSenha());
    cliente.setSenha(hashSenha);
    mv.addObject("usuario", cliente);
    try {
      if (UploadUtil.fazerUploading(imagem)) {
        cliente.setImagem(imagem.getOriginalFilename());
      }
      clienteRepository.save(cliente);
      System.out.println("Salvo com sucesso " + cliente.getNome() + " " + cliente.getImagem());
      return homeService.getHome();
    } catch (Exception e) {
      mv.addObject("msgErro", e.getMessage());
      System.out.println("Erro ao salvar" + e.getMessage());
      return mv;
    }
  }

  @GetMapping(value = "list-clientes")
  public ModelAndView clientesList() {
    ModelAndView mv = new ModelAndView("cliente/cliente-list");
    mv.addObject("clientes", clienteRepository.findAll());
    return mv;
  }

  @GetMapping("excluir/{id}")
  public ModelAndView excluirCliente(@PathVariable("id") Integer id) {
    clienteRepository.deleteById(id);
    return homeService.getHome();
  }

  @GetMapping("editar/{id}")
  public ModelAndView editarCliente(@PathVariable("id") Integer id) {
    ModelAndView mv = new ModelAndView("cliente/editar");
    mv.addObject("perfils", Perfil.values());
    mv.addObject("usuario", clienteRepository.findById(id));
    return mv;
  }

  @PostMapping("editar-cliente")
  public ModelAndView editarC(Cliente cliente) {
    clienteRepository.save(cliente);
    return clientesList();
  }
}
