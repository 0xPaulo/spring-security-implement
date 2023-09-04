package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.security.model.ClienteUserDetails;
import com.security.service.ClienteUserDetailsService;
import com.security.service.TecnicoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebConfigProject extends WebSecurityConfigurerAdapter {

        @Autowired
        private ClienteUserDetailsService clienteUserDetailsService;
        @Autowired
        private TecnicoUserDetailsService tecnicoUserDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                                // .antMatchers("/**").permitAll()
                                .antMatchers("/images/**").permitAll()
                                .antMatchers("/js/**").permitAll()
                                .antMatchers("/fonts/**").permitAll()
                                .antMatchers("vendors/**").permitAll()
                                .antMatchers("/css/**").permitAll()
                                .anyRequest().authenticated();

                http.formLogin()
                                .loginPage("/login")
                                .defaultSuccessUrl("/", true)
                                .permitAll();

                http.logout()
                                .logoutRequestMatcher(
                                                new AntPathRequestMatcher("/logout", "GET"))
                                .logoutSuccessUrl("/login");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(tecnicoUserDetailsService)
                                .passwordEncoder(new BCryptPasswordEncoder());
                auth.userDetailsService(clienteUserDetailsService)
                                .passwordEncoder(new BCryptPasswordEncoder());
        }
}
