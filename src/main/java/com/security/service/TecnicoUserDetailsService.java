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
    Tecnico tecnico = tecnicoRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado na base de dados!"));
    return new TecnicoUserDetails(tecnico);
  }

}
