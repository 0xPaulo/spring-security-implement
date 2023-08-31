package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
