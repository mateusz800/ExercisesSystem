package com.example.core.domain.service.user;

import com.example.core.domain.dto.user.PostRegisterRequestDto;
import com.example.core.domain.entity.User;
import com.example.core.domain.exception.UserAlreadyExistsException;
import com.example.core.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("userService")
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(PostRegisterRequestDto dto) throws UserAlreadyExistsException {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
        } else {
            User userEntity = new User(dto.getEmail(), dto.getPassword());
            userRepository.save(userEntity);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Bad credentials");
        }
        return user.get();
    }
}
