package com.github.trojnartom.singinglessonscalendar.repository;

import com.github.trojnartom.singinglessonscalendar.model.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository <LessonEntity, Long> {

}
