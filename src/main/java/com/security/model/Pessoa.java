package com.security.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.security.Enum.Perfil;
import java.util.Objects;

@MappedSuperclass
public abstract class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String senha;
  private String imagem;
  private Perfil perfil;

  public Pessoa() {
  }

  public Pessoa(Integer id, String nome, String email, String senha, String imagem, Perfil perfil) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.imagem = imagem;
    this.perfil = perfil;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getImagem() {
    return this.imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public Perfil getPerfil() {
    return this.perfil;
  }

  public void setPerfil(Perfil perfil) {
    this.perfil = perfil;
  }

  public Pessoa id(Integer id) {
    setId(id);
    return this;
  }

  public Pessoa nome(String nome) {
    setNome(nome);
    return this;
  }

  public Pessoa email(String email) {
    setEmail(email);
    return this;
  }

  public Pessoa senha(String senha) {
    setSenha(senha);
    return this;
  }

  public Pessoa imagem(String imagem) {
    setImagem(imagem);
    return this;
  }

  public Pessoa perfil(Perfil perfil) {
    setPerfil(perfil);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pessoa)) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(email, pessoa.email)
        && Objects.equals(senha, pessoa.senha) && Objects.equals(imagem, pessoa.imagem)
        && Objects.equals(perfil, pessoa.perfil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, email, senha, imagem, perfil);
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", nome='" + getNome() + "'" +
        ", email='" + getEmail() + "'" +
        ", senha='" + getSenha() + "'" +
        ", imagem='" + getImagem() + "'" +
        ", perfil='" + getPerfil() + "'" +
        "}";
  }

}