package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.Cliente;
import com.security.model.ClienteUserDetails;
import com.security.repository.ClienteRepository;

@Service
public class ClienteUserDetailsService implements UserDetailsService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Cliente cliente = clienteRepository.procurarClienteNoBanco(email);
    if (cliente == null) {
      throw new UsernameNotFoundException("nao existe esse cliente no banco");
    }
    UserDetails userDetails = new ClienteUserDetails(cliente);

    return userDetails;

  }

}
