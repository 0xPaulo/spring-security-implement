package com.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TecnicoUserDetails implements UserDetails {

  private Tecnico tecnico;

  public TecnicoUserDetails(Tecnico tecnico) {
    this.tecnico = tecnico;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getNome() {
    return tecnico.getNome();
  }

  public Integer getId() {
    return tecnico.getId();
  }

  @Override
  public String getPassword() {
    return tecnico.getSenha();
  }

  @Override
  public String getUsername() {
    return tecnico.getEmail();
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
