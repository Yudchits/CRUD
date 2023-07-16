package by.yudchits.uiip.crud_service.dao;

import by.yudchits.uiip.crud_service.entity.Faculty;

import java.util.List;

public interface FacultyDAO {
    List<Faculty> findAllFaculties();
    Faculty findFacultyById(long id);
    void saveOrUpdateFaculty(Faculty faculty);
    void deleteFacultyById(long id);
}
