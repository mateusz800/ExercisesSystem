package com.example.core.domain.configuration.security;


import com.example.core.domain.configuration.Configuration;
import com.example.core.domain.entity.user.Role;
import com.example.core.domain.entity.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException {
        try {
            User credentials = new ObjectMapper().readValue(req.getInputStream(), User.class);
            Authentication test = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getLogin(),
                            credentials.getPassword(),
                            new ArrayList<>()));
            return test;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain,
                                            Authentication authResult) throws IOException {
        Map<String, Object> claims = new HashMap<>();
        Set<String> userRoles = new HashSet<>();

        Date expirationDate = new Date(System.currentTimeMillis() + JWTSecurityConfiguration.EXPIRATION_INTERVAL);
        User user = (User) authResult.getPrincipal();

        for(Role role:user.getRoles()){
            userRoles.add(role.getName());
        }
        //claims.put("Roles", user.getAuthorities());
        claims.put("Roles", userRoles.toArray());
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getLogin())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, Configuration.getAuthKey().getBytes(StandardCharsets.UTF_8))
                .compact();
        resp.addHeader("Access-Control-Expose-Headers", JWTSecurityConfiguration.TOKEN_NAME);
        resp.addHeader("jwt", token);
    }
}
