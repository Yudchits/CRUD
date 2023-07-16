package by.yudchits.uiip.crud_service.dao;

import by.yudchits.uiip.crud_service.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAllStudents();
    Student findStudentById(long id);
    void saveOrUpdateStudent(Student student);
    void deleteStudentById(long id);
}
