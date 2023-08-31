package com.security.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class Tecnico extends Pessoa {

  @OneToMany(mappedBy = "tecnico")
  private List<Chamado> chamados = new ArrayList<>();

  public Tecnico() {
  }

  public Tecnico(List<Chamado> chamados) {
    this.chamados = chamados;
  }

  public List<Chamado> getChamados() {
    return this.chamados;
  }

  public void setChamados(List<Chamado> chamados) {
    this.chamados = chamados;
  }

  public Tecnico chamados(List<Chamado> chamados) {
    setChamados(chamados);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Tecnico)) {
      return false;
    }
    Tecnico tecnico = (Tecnico) o;
    return Objects.equals(chamados, tecnico.chamados);
  }

}
