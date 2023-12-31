package by.yudchits.uiip.crud_service.service;

import by.yudchits.uiip.crud_service.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAllFaculties();
    Faculty findFacultyById(long id);
    void saveOrUpdateFaculty(Faculty faculty);
    void deleteFacultyById(long id);
}
