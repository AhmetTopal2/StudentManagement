package com.calculatenote.repository;

import com.calculatenote.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonRepo extends JpaRepository<Lesson , Long> {
}
