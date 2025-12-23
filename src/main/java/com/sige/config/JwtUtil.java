package com.sige.config;

import com.sige.model.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY =
            "SIGE_SUPER_CHAVE_SECRETA_QUE_DEVE_TER_32_CHARS";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 6; // 6 horas

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public static String generateToken(Usuario usuario) {

        /*
         🔥 SUBJECT CORRETO:
         prioridade → email > cpf > cnpj > matrícula
        */
        String principal =
                usuario.getEmail() != null ? usuario.getEmail()
                        : usuario.getCpf() != null ? usuario.getCpf()
                        : usuario.getCnpj() != null ? usuario.getCnpj()
                        : usuario.getMatricula();

        return Jwts.builder()
                .setSubject(principal) // 🔥 NUNCA MAIS ID
                .claim("role", usuario.getRole().name())
                .claim("tipo", usuario.getTipo())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
