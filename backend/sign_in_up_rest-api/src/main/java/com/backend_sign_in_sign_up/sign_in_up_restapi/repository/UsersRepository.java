package com.backend_sign_in_sign_up.sign_in_up_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend_sign_in_sign_up.sign_in_up_restapi.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
