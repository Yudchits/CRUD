package by.yudchits.uiip.crud_service.service.impl;

import by.yudchits.uiip.crud_service.dao.FacultyDAO;
import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    public List<Faculty> findAllFaculties() {
        return facultyDAO.findAllFaculties();
    }
}
