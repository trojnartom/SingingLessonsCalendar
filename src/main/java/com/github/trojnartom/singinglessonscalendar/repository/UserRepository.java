package com.github.trojnartom.singinglessonscalendar.repository;

import com.github.trojnartom.singinglessonscalendar.model.RoleEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserById(Long id);

    UserEntity findByRole(RoleEntity role);
}
