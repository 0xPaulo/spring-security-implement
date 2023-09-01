package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

  Optional<Tecnico> findByEmail(String email);

}
