package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Chamado;
import com.security.repository.ChamadoRepository;

@Service
public class ChamadoService {

  @Autowired
  ChamadoRepository chamadoRepository;

  public List<Chamado> findAllChamados() {
    return chamadoRepository.buscarTodosChamados();
  }

}
