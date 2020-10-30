package com.example.core.domain.service.user;

import com.example.core.domain.dto.user.PostRegisterRequestDto;
import com.example.core.domain.exception.UserAlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    void register(PostRegisterRequestDto dto) throws UserAlreadyExistsException;
}
