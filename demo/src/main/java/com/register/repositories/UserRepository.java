package com.register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String username);

    boolean existsByUserNameAndPassword(String username, String password);
}
