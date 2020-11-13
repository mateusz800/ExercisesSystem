package com.example.core.domain.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user", schema = "math")
public class User implements UserDetails {
    @Id
    @Column(name="email")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permissions", joinColumns = {
            @JoinColumn(name = "user_email") }, inverseJoinColumns = {
            @JoinColumn(name = "role_name") })
    private Set<Role> roles;


    public User(){}

    public User(String email, String password){
        this.login = email;
        this.password = password;
    }
    public void setLogin(String email){
        this.login = email;
    }
    public String getLogin(){
        return login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
