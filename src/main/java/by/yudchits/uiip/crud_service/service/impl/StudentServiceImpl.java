package by.yudchits.uiip.crud_service.service.impl;

import by.yudchits.uiip.crud_service.dao.StudentDAO;
import by.yudchits.uiip.crud_service.entity.Student;
import by.yudchits.uiip.crud_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> findAllStudents() {
        return studentDAO.findAllStudents();
    }

    @Override
    @Transactional
    public Student findStudentById(long id) {
        return studentDAO.findStudentById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateStudent(Student student) {
        studentDAO.saveOrUpdateStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(long id) {
        studentDAO.deleteStudentById(id);
    }
}
