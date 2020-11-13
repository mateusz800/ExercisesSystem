package com.example.teacherMicroservice.configuration;


import com.example.core.domain.service.user.IUserService;
import com.example.teacherMicroservice.component.MyBasicAuthenticationEntryPoint;
import com.example.core.domain.configuration.security.JWTAuthenticationFilter;
import com.example.core.domain.configuration.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(iUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .cors().disable()

                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // allow unauthorized
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/images/course/*.png").permitAll()
               // .anyRequest().hasRole("student")
                .anyRequest().hasAuthority("teacher");


                //.anyRequest().authenticated();

        httpSecurity
                .addFilterBefore(new JWTAuthorizationFilter(authenticationManager(), iUserService), JWTAuthorizationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), JWTAuthenticationFilter.class);
    }
}
