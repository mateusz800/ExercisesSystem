package com.example.core.domain.repository;

import com.example.core.domain.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query(value="SELECT * FROM math.user WHERE email = ? ", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
