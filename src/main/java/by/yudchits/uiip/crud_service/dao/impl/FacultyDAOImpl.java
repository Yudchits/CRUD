package by.yudchits.uiip.crud_service.dao.impl;

import by.yudchits.uiip.crud_service.dao.FacultyDAO;
import by.yudchits.uiip.crud_service.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FacultyDAOImpl implements FacultyDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Faculty> findAllFaculties() {
        Session session = factory.getCurrentSession();

        return session.createQuery("from Faculty", Faculty.class).getResultList();
    }

    @Override
    public Faculty findFacultyById(long id) {
        Session session = factory.getCurrentSession();

        return session.get(Faculty.class, id);
    }

    @Override
    public void saveOrUpdateFaculty(Faculty faculty) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(faculty);
    }

    @Override
    public void deleteFacultyById(long id) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("delete from Faculty where id =: faculty_id");
        query.setParameter("faculty_id", id);

        query.executeUpdate();
    }
}
