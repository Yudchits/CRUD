package by.yudchits.uiip.crud_service.dao.impl;

import by.yudchits.uiip.crud_service.dao.StudentDAO;
import by.yudchits.uiip.crud_service.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Student> findAllStudents() {
        Session session = factory.getCurrentSession();

        return session.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findStudentById(long id) {
        Session session = factory.getCurrentSession();

        return session.get(Student.class, id);
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(student);
    }

    @Override
    public void deleteStudentById(long id) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("delete from Student where id =: student_id");
        query.setParameter("student_id", id);
        query.executeUpdate();
    }
}
