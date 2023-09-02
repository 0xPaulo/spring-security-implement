package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.Tecnico;
import com.security.model.TecnicoUserDetails;
import com.security.repository.TecnicoRepository;

@Service
public class TecnicoUserDetailsService implements UserDetailsService {

  @Autowired
  private TecnicoRepository tecnicoRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Tecnico tecnico = tecnicoRepository.findByEmailNoBanco(email);
    if (tecnico == null) {
      throw new UsernameNotFoundException("Usuario nao encontrado" + tecnico);
    }
    UserDetails userDetails = new TecnicoUserDetails(tecnico);
    return userDetails;
  }

}
