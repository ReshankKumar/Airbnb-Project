package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertUserRepository extends JpaRepository<PropertyUser, Long> {

    Optional<PropertyUser> findByUsername(String username);
}