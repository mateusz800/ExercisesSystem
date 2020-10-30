package com.example.user.configuration.security;

import com.example.core.domain.entity.User;
import com.example.core.domain.repository.SystemConfigRepository;
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
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private SystemConfigRepository systemConfigRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, SystemConfigRepository systemConfigRepository) {
        setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
        this.systemConfigRepository = systemConfigRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException {
        try {
            User credentials = new ObjectMapper().readValue(req.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,HttpServletResponse resp, FilterChain chain,
                                            Authentication authResult) throws IOException {
       Date expirationDate = new Date(System.currentTimeMillis() + JWTSecurityConfiguration.EXPIRATION_INTERVAL);
       User user = (User) authResult.getPrincipal();
       String token = Jwts.builder()
               .setSubject(user.getEmail())
               .setExpiration(expirationDate)
               .signWith(SignatureAlgorithm.ES512, systemConfigRepository.getParam("AUTH_KEY").getValue().getBytes(StandardCharsets.UTF_8))
               .compact();
       resp.addHeader("Access-Control-Expose-Headers", JWTSecurityConfiguration.TOKEN_NAME);
       resp.addHeader("jwt", token);
    }
}
