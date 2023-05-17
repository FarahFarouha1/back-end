package com.farah.patients.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farah.patients.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}