package com.example.teacherMicroservice.component;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet(){
        setRealmName("TeacherAPI");
        super.afterPropertiesSet();
    }
}
