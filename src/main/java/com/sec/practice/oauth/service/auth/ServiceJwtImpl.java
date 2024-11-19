package com.sec.practice.oauth.service.auth;

import com.sec.practice.oauth.persistence.entities.sec.User;
import com.sec.practice.oauth.persistence.repository.RepositoryUser;
import com.sec.practice.oauth.persistence.util.fileproperty.JwtProperty;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.crypto.SecretKey;

@Service
public class ServiceJwtImpl {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private JwtProperty jwtProperty;

    public String generateJwt(User userdto){
        Date issu = new Date(System.currentTimeMillis());
        Date exp = new Date((jwtProperty.getMinute_exp() * 60 * 100) + issu.getTime());
         return Jwts.builder()
                 .header()
                 .type("JWT")
                 .add("alg", Jwts.SIG.HS256.toString())
                 .and()
                 .subject(userdto.getUsername())
                 .claims(generateClaims(userdto))
                 .issuedAt(issu)
                 .expiration(exp)
                 .signWith(generateKey())
                 .compact();
    }

    public Map<String, Object> generateClaims(User user) {
        Map<String, Object>  map = new HashMap<>();
        map.put("authorities", user.getAuthorities());
        map.put("password", user.getPassword() );
        return map;
    }

    public SecretKey generateKey() {
        byte[] bytes = Decoders.BASE64.decode(jwtProperty.getSecret_key());
        System.out.println(new String(bytes));
        return Keys.hmacShaKeyFor(bytes);
    }

    public String extractSubject(String jwt){
        return extractClaims(jwt).getSubject();
    }


    public Claims extractClaims(String jwt){
        return Optional.of(Jwts.parser().verifyWith(generateKey())
                .build().parseSignedClaims(jwt).getPayload()).orElse(null);
    }

}