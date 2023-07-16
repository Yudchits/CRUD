package by.yudchits.uiip.crud_service.service;

import by.yudchits.uiip.crud_service.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(long id);
    void saveOrUpdateStudent(Student student);
    void deleteStudentById(long id);
}
