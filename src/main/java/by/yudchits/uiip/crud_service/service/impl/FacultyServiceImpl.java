package by.yudchits.uiip.crud_service.service.impl;

import by.yudchits.uiip.crud_service.dao.FacultyDAO;
import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    @Transactional
    public List<Faculty> findAllFaculties() {
        return facultyDAO.findAllFaculties();
    }

    @Override
    @Transactional
    public Faculty findFacultyById(long id) {
        return facultyDAO.findFacultyById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateFaculty(Faculty faculty) {
        facultyDAO.saveOrUpdateFaculty(faculty);
    }

    @Override
    @Transactional
    public void deleteFacultyById(long id) {
        facultyDAO.deleteFacultyById(id);
    }
}
