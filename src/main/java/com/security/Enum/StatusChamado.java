package com.security.Enum;

public enum StatusChamado {
  ABERTO("Aberto"),
  ANDAMENTO("Em Andamento"),
  FECHADO("Fechado");

  private final String descricao;

  private StatusChamado(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}
