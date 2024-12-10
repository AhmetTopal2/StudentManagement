package com.calculatenote.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
public class DtoLesson {

    private Long id;

    private String lessonName;

    private Integer lessonNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Integer getLessonNote() {
        return lessonNote;
    }

    public void setLessonNote(Integer lessonNote) {
        this.lessonNote = lessonNote;
    }
}
