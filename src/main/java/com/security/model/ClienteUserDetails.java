package com.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ClienteUserDetails implements UserDetails {

  private Cliente cliente;

  public ClienteUserDetails(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getNome() {
    return cliente.getNome();
  }

  public Integer getId() {
    return cliente.getId();
  }

  public String imagemPerfil() {
    return cliente.getImagem();
  }

  @Override
  public String getPassword() {
    return cliente.getSenha();
  }

  @Override
  public String getUsername() {
    return cliente.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
