package by.yudchits.uiip.crud_service.dao.impl;

import by.yudchits.uiip.crud_service.dao.FacultyDAO;
import by.yudchits.uiip.crud_service.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
