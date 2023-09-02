package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  @Query(value = "SELECT * FROM cliente WHERE email = :email", nativeQuery = true)
  Cliente procurarClienteNoBanco(@Param("email") String email);
}
