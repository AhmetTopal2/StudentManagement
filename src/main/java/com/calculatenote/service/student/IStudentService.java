package com.calculatenote.service.student;

import com.calculatenote.dto.DtoStudent;
import com.calculatenote.model.Student;

import java.util.List;

public interface IStudentService {

    DtoStudent getStudentById(Long id);

    List<DtoStudent> getAllStudents();

    DtoStudent createStudent(Student student);

    DtoStudent updateStudent(Student student);

    void deleteStudentById(Long id);
}
