package com.example.core.domain.repository.user;

import com.example.core.domain.entity.user.Role;
import com.example.core.domain.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}
