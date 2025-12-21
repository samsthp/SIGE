package com.sigecertificado.sige_emissao_certificado_estagio.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class CertificadoSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http   
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()    
                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/login.html",
                    "/cadastroaluno.html",
                    "/cadastroempresa.html",
                    "/cadastrocoordenador.html",
                    "/dashboardaluno.html",
                    "/dashboardempresa.html",
                    "/dashboardcoordenador.html"
                ).permitAll()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login.html")
                .permitAll()
            )
            .httpBasic(basic -> basic.disable())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .permitAll()
            );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService user(PasswordEncoder codificador) {
        UserDetails user = User
            .withUsername("admin")
            .password(codificador.encode("123454321"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
