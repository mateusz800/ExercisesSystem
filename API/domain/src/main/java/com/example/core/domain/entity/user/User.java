package com.example.core.domain.entity.user;

import com.example.core.domain.entity.Answer;
import com.example.core.domain.entity.Course;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permissions", schema = "math", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_name") })
    private Set<Role> roles;

    @ManyToMany(mappedBy = "authors")
    private Set<Course> courses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Answer> givenAnswers;


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

    public void setsRole(Set<Role> roles){
        this.roles = roles;
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


    public Long getId() {
        return id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
