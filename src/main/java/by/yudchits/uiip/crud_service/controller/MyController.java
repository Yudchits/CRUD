package by.yudchits.uiip.crud_service.controller;

import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.entity.Student;
import by.yudchits.uiip.crud_service.service.FacultyService;
import by.yudchits.uiip.crud_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/main")
    public String showAllStudents(Model model){
        List<Student> students = studentService.findAllStudents();
        List<Faculty> faculties = facultyService.findAllFaculties();

        model.addAttribute("students", students);
        model.addAttribute("faculties", faculties);

        return "all-information";
    }
}
