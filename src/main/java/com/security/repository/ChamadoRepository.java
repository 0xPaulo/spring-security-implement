package com.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.security.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

  @Query(value = "select * from chamado", nativeQuery = true)
  public List<Chamado> buscarTodosChamados();

}
