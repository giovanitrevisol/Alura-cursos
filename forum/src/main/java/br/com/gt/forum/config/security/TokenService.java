package br.com.gt.forum.config.security;

import br.com.gt.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario login = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dateExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API do Forum")
                .setSubject(login.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dateExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
