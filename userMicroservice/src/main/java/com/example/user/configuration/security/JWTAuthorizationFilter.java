package com.example.user.configuration.security;

import com.example.core.domain.configuration.Configuration;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.repository.UserRepository;
import com.example.core.domain.service.user.IUserService;
import com.example.core.domain.service.user.UserService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private IUserService userService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, IUserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JWTSecurityConfiguration.HEADER);
        if (header == null || !header.startsWith(JWTSecurityConfiguration.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
            if (authentication == null) {
                SecurityContextHolder.clearContext();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (JwtException e) {
            SecurityContextHolder.clearContext();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JWTSecurityConfiguration.HEADER);
        String user = null;
        Date expirationDate;
        if (token != null) {
            user = Jwts
                    .parser()
                    .setSigningKey(Configuration.getAuthKey().getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token.replace(JWTSecurityConfiguration.TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                expirationDate = Jwts
                        .parser()
                        .setSigningKey(Configuration.getAuthKey().getBytes(StandardCharsets.UTF_8))
                        .parseClaimsJws(token.replace(JWTSecurityConfiguration.TOKEN_PREFIX, ""))
                        .getBody()
                        .getExpiration();
                Date now = new Date(System.currentTimeMillis());
                if (!now.after(expirationDate)) {
                    UserDetails userEntity = userService.loadUserByUsername(user);
                    return new UsernamePasswordAuthenticationToken(user, null, userEntity.getAuthorities());
                }
            }
        }
        return null;
    }
}
