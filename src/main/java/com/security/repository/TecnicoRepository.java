package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

  Optional<Tecnico> findByEmail(String email);

  @Query(value = "SELECT * FROM tecnico WHERE email = :email", nativeQuery = true)
  Tecnico findByEmailNoBanco(@Param("email") String email);

}
