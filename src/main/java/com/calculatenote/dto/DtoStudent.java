package com.calculatenote.dto;


import lombok.*;


import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {

    private Long id;

    private String name;

    private String surName;

    private List<DtoLesson> dtoLessons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<DtoLesson> getDtoLessons() {
        return dtoLessons;
    }

    public void setDtoLessons(List<DtoLesson> dtoLessons) {
        this.dtoLessons = dtoLessons;
    }
}
