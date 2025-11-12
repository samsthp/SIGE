package com.sige.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // ✅ Habilita CORS e desativa CSRF (essencial para Postman e front-end)
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())

                // ✅ Libera as rotas públicas
                .authorizeHttpRequests(auth -> auth
                        // Libera explicitamente login e registro (qualquer método HTTP)
                        .requestMatchers("/api/auth/register").permitAll()
                        .requestMatchers("/api/auth/login").permitAll()

                        // Libera também os recursos do front-end
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

                        // Bloqueia o resto
                        .anyRequest().authenticated()
                )

                // 🚫 Desativa autenticação padrão
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                // ✅ Configura logout (opcional)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login.html")
                        .permitAll()
                );

        return http.build();
    }

    // ✅ Encoder de senha (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ Configuração global de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*")); // aceita qualquer origem (Postman, localhost, etc.)
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false); // false para evitar conflitos no Postman

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
