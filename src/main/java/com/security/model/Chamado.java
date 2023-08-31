package com.security.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.security.Enum.Prioridade;
import com.security.Enum.StatusChamado;
import java.util.Objects;

@Entity
public class Chamado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String titulo;
  private LocalDate dataAbertura = LocalDate.now();
  private LocalDate dataFechamento;
  private String observacao;
  private StatusChamado status;
  private Prioridade prioridade;

  @ManyToOne
  @JoinColumn(name = "tecnico_id_fk")
  private Tecnico tecnico;
  @ManyToOne
  @JoinColumn(name = "cliente_id_fk")
  private Cliente cliente;

  public Chamado() {
  }

  public Chamado(Integer id, String titulo, LocalDate dataAbertura, LocalDate dataFechamento, String observacao,
      StatusChamado status, Prioridade prioridade, Tecnico tecnico, Cliente cliente) {
    this.id = id;
    this.titulo = titulo;
    this.dataAbertura = dataAbertura;
    this.dataFechamento = dataFechamento;
    this.observacao = observacao;
    this.status = status;
    this.prioridade = prioridade;
    this.tecnico = tecnico;
    this.cliente = cliente;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public LocalDate getDataAbertura() {
    return this.dataAbertura;
  }

  public void setDataAbertura(LocalDate dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public LocalDate getDataFechamento() {
    return this.dataFechamento;
  }

  public void setDataFechamento(LocalDate dataFechamento) {
    this.dataFechamento = dataFechamento;
  }

  public String getObservacao() {
    return this.observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public StatusChamado getStatus() {
    return this.status;
  }

  public void setStatus(StatusChamado status) {
    this.status = status;
  }

  public Prioridade getPrioridade() {
    return this.prioridade;
  }

  public void setPrioridade(Prioridade prioridade) {
    this.prioridade = prioridade;
  }

  public Tecnico getTecnico() {
    return this.tecnico;
  }

  public void setTecnico(Tecnico tecnico) {
    this.tecnico = tecnico;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Chamado id(Integer id) {
    setId(id);
    return this;
  }

  public Chamado titulo(String titulo) {
    setTitulo(titulo);
    return this;
  }

  public Chamado dataAbertura(LocalDate dataAbertura) {
    setDataAbertura(dataAbertura);
    return this;
  }

  public Chamado dataFechamento(LocalDate dataFechamento) {
    setDataFechamento(dataFechamento);
    return this;
  }

  public Chamado observacao(String observacao) {
    setObservacao(observacao);
    return this;
  }

  public Chamado status(StatusChamado status) {
    setStatus(status);
    return this;
  }

  public Chamado prioridade(Prioridade prioridade) {
    setPrioridade(prioridade);
    return this;
  }

  public Chamado tecnico(Tecnico tecnico) {
    setTecnico(tecnico);
    return this;
  }

  public Chamado cliente(Cliente cliente) {
    setCliente(cliente);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Chamado)) {
      return false;
    }
    Chamado chamado = (Chamado) o;
    return Objects.equals(id, chamado.id) && Objects.equals(titulo, chamado.titulo)
        && Objects.equals(dataAbertura, chamado.dataAbertura) && Objects.equals(dataFechamento, chamado.dataFechamento)
        && Objects.equals(observacao, chamado.observacao) && Objects.equals(status, chamado.status)
        && Objects.equals(prioridade, chamado.prioridade) && Objects.equals(tecnico, chamado.tecnico)
        && Objects.equals(cliente, chamado.cliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titulo, dataAbertura, dataFechamento, observacao, status, prioridade, tecnico, cliente);
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", titulo='" + getTitulo() + "'" +
        ", dataAbertura='" + getDataAbertura() + "'" +
        ", dataFechamento='" + getDataFechamento() + "'" +
        ", observacao='" + getObservacao() + "'" +
        ", status='" + getStatus() + "'" +
        ", prioridade='" + getPrioridade() + "'" +
        ", tecnico='" + getTecnico() + "'" +
        ", cliente='" + getCliente() + "'" +
        "}";
  }

}
