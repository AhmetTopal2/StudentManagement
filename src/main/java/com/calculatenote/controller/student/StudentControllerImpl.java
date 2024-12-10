package com.calculatenote.controller.student;

import com.calculatenote.dto.DtoStudent;
import com.calculatenote.model.Student;
import com.calculatenote.response.CreateResponse;
import com.calculatenote.response.MyResponse;
import com.calculatenote.service.student.IStudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController{

    @Autowired
    IStudentService studentService;

    @Autowired
    CreateResponse createResponse;


    @GetMapping(path = "/get/{id}", produces = "application/json")
    @Override
    public ResponseEntity<MyResponse<DtoStudent>> getStudentById(
            @PathVariable(name = "id") Long id, HttpServletRequest request) {
        DtoStudent dtoStudent = studentService.getStudentById(id);

        if (dtoStudent != null && dtoStudent.getId() != null) {
            return new ResponseEntity<>(createResponse.ok(dtoStudent, request), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(createResponse.notFound("Student not found with id: " + id, request),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/getAll" ,produces = "application/json")
    @Override
    public ResponseEntity<MyResponse<List<DtoStudent>>> getAllStudents(HttpServletRequest request) {
        List<DtoStudent> dtoStudentList = studentService.getAllStudents();

        if (!dtoStudentList.isEmpty()){
            return new ResponseEntity<>(createResponse.ok(dtoStudentList , request ) , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(createResponse.notFound("Students Not Found" , request) , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/create")
    @Override
    public ResponseEntity<MyResponse<DtoStudent>> createStudent(@RequestBody Student student , HttpServletRequest request) {
        DtoStudent dtoStudent = studentService.createStudent(student);

        if (dtoStudent != null && dtoStudent.getId() != null){
            return  new ResponseEntity<>(createResponse.ok(dtoStudent , request) , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(createResponse.notFound("Could not save" , request) , HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping(path = "/update")
    @Override
    public ResponseEntity<MyResponse<DtoStudent>> updateStudent(@RequestBody Student student , HttpServletRequest request) {
       DtoStudent dtoStudent =  studentService.updateStudent(student);
        if (dtoStudent != null && dtoStudent.getId() != null){
            return new ResponseEntity<>(createResponse.ok(dtoStudent , request) , HttpStatus.OK) ;
        }else {
            return new ResponseEntity<>(createResponse.notFound("Could Not Update" , request) , HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Long id) {
            studentService.deleteStudentById(id);

    }

}
