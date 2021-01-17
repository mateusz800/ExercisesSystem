package com.example.core.domain.dto.user;

public class PostRegisterRequestDto {
    private String email;
    private String password;

    public PostRegisterRequestDto(){}

    public PostRegisterRequestDto(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
