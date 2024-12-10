package com.calculatenote.controller.student;

import com.calculatenote.dto.DtoStudent;
import com.calculatenote.model.Student;
import com.calculatenote.response.MyResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentController {
    ResponseEntity<MyResponse<DtoStudent>> getStudentById(Long id , HttpServletRequest request);

    ResponseEntity<MyResponse<List<DtoStudent>>> getAllStudents(HttpServletRequest request);

    ResponseEntity<MyResponse<DtoStudent>> createStudent(Student student , HttpServletRequest request);

    ResponseEntity<MyResponse<DtoStudent>> updateStudent(Student student , HttpServletRequest request);

    void deleteStudentById(Long id);
}
