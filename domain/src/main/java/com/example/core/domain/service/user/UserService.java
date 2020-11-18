package com.example.core.domain.service.user;

import com.example.core.domain.dto.user.PostRegisterRequestDto;
import com.example.core.domain.entity.user.Role;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.exception.UserAlreadyExistsException;
import com.example.core.domain.repository.user.RoleRepository;
import com.example.core.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public void register(PostRegisterRequestDto dto) throws UserAlreadyExistsException {
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
        } else {
            User userEntity = new User();
            userEntity.setLogin(dto.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
            userEntity.setRoles(new HashSet<Role>(Collections.singletonList(roleRepository.findById("student").orElseThrow())));
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
