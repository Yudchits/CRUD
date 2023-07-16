package by.yudchits.uiip.crud_service.controller;

import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.entity.Student;
import by.yudchits.uiip.crud_service.service.FacultyService;
import by.yudchits.uiip.crud_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @RequestMapping("/add-student")
    public String addNewStudent(Model model){
        model.addAttribute("student", new Student());

        return "add-update-student";
    }

    @RequestMapping("/save-update-student")
    public String saveOrUpdateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        List<Faculty> faculties = facultyService.findAllFaculties();

        for (Faculty faculty : faculties) {
            if(student.getFaculty().getName().equals(faculty.getName())){
                studentService.saveOrUpdateStudent(student);
                return "redirect:/main";
            }
        }

        bindingResult.rejectValue("faculty", "error.faculty", "Такого факультета не существует");
        return "add-update-student";
    }
}
