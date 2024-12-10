package com.calculatenote.service.student;

import com.calculatenote.dto.DtoLesson;
import com.calculatenote.dto.DtoStudent;
import com.calculatenote.exception.BaseException;
import com.calculatenote.exception.ErrorMessage;
import com.calculatenote.exception.MessageType;
import com.calculatenote.model.Lesson;
import com.calculatenote.model.Student;
import com.calculatenote.repository.ILessonRepo;
import com.calculatenote.repository.IStudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    IStudentRepo studentRepo;

    @Autowired
    ILessonRepo lessonRepo;


    private DtoStudent convertToDto(Student student) {
        DtoStudent dtoStudent = new DtoStudent();
        dtoStudent.setId(student.getId());
        dtoStudent.setName(student.getName());
        dtoStudent.setSurName(student.getSurName());
        dtoStudent.setDtoLessons(convertLessonListToDto(student.getLessons()));
        return dtoStudent;
    }

    private List<DtoLesson> convertLessonListToDto(List<Lesson> lessons) {
        List<DtoLesson> dtoLessons = new ArrayList<>();
        for (Lesson lesson : lessons) {
            DtoLesson dtoLesson = new DtoLesson();
            dtoLesson.setId(lesson.getId());
            dtoLesson.setLessonName(lesson.getLessonName());
            dtoLesson.setLessonNote(lesson.getLessonNote());
            dtoLessons.add(dtoLesson);
        }
        return dtoLessons;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
        Optional<Student> optional = studentRepo.findById(id);

        if (optional.isPresent()){
            return convertToDto(optional.get());
        }else {

            throw new BaseException(new ErrorMessage( "Kullanici Bulunamadi" , MessageType.NO_RECORD_EXIST ));

        }

    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> dbStudentList = studentRepo.findAll();
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        if (!dbStudentList.isEmpty()){
            for(Student student : dbStudentList){
                dtoStudentList.add(convertToDto(student));
            }
        }else {
            throw new BaseException(new ErrorMessage( "Kullanici Bulunamadi" , MessageType.NO_RECORD_EXIST ));
        }
        return dtoStudentList;
    }

    @Override
    public DtoStudent createStudent(Student student) {
        Student dbStudent = studentRepo.save(student);

        if (dbStudent.getId()!=null){
            return convertToDto(dbStudent);
        }else {
            throw new BaseException(new ErrorMessage( "Kullanıcı olusturma sırasında bır hata olustu" , MessageType.NO_RECORD_EXIST ));
        }
    }

    @Override
    public DtoStudent updateStudent(Student student) {
        Student dbStudent = studentRepo.save(student);

        if (dbStudent.getId()!=null){
            convertToDto(dbStudent);
        }else {
            throw new BaseException(new ErrorMessage( "Kullanıcı guncellemesı sırasında bır hata olustu" , MessageType.NO_RECORD_EXIST ));
        }
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {
            studentRepo.deleteById(id);
    }
}
