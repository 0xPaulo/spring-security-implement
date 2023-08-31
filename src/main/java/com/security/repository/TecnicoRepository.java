package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
