package com.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

  public static String encoder(String senha) {
    BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
    return encriptador.encode(senha);
  }
}
