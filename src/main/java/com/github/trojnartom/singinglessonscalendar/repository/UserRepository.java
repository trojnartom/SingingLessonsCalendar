package com.github.trojnartom.singinglessonscalendar.repository;

import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findAllByIsAdmin(String isAdmin);
    Optional<UserEntity> findByEmail(String email);

}
