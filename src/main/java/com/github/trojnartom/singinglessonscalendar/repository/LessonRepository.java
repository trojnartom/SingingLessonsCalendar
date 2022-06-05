package com.github.trojnartom.singinglessonscalendar.repository;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import com.github.trojnartom.singinglessonscalendar.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository <LessonEntity, Long> {

    @Query(value = "SELECT * FROM lessons WHERE user_id = :userId", nativeQuery = true)
    List<LessonEntity> findAllByUserId (@Param("userId") Long userId);

    @Query(value = "SELECT * FROM lessons WHERE status = :status", nativeQuery = true)
    List<LessonEntity> findAllByStatus (@Param("status") String status);
}
