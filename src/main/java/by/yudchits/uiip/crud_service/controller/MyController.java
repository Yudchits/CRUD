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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/main")
    public String showAllStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        List<Faculty> faculties = facultyService.findAllFaculties();

        model.addAttribute("students", students);
        model.addAttribute("faculties", faculties);

        return "all-information";
    }

    @RequestMapping("/add-student")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());

        return "add-update-student";
    }

    @RequestMapping("/update-student-details")
    public String updateStudentDetails(@RequestParam("id") long id, Model model) {
        Student student = studentService.findStudentById(id);

        model.addAttribute("student", student);

        return "add-update-student";
    }

    @RequestMapping("/save-update-student")
    public String saveOrUpdateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (student.getId() != 0) {
            return changeStudentDetails(student, bindingResult);
        } else {
            return saveNewStudent(student, bindingResult);
        }
    }

    private String saveNewStudent(Student student, BindingResult bindingResult) {
        Faculty faculty = isFacultyExisted(student.getFaculty());

        boolean isEmailExisted = isEmailExisted(student.getEmail());

        if (faculty == null) {
            bindingResult.rejectValue("faculty", "error.faculty", "Such faculty doesn't exist");
        }
        if (isEmailExisted) {
            bindingResult.rejectValue("email", "error.email", "Such email already exists");
        }

        if (bindingResult.hasErrors()) {
            return "add-update-student";
        } else {
            student.setFaculty(faculty);
            studentService.saveOrUpdateStudent(student);
            return "redirect:/main";
        }
    }

    private String changeStudentDetails(Student student, BindingResult bindingResult) {
        return "redirect:/main";
    }

    private Faculty isFacultyExisted(Faculty searchedFaculty) {
        List<Faculty> faculties = facultyService.findAllFaculties();

        for (Faculty faculty : faculties) {
            if (searchedFaculty.getName().equals(faculty.getName()))
                return faculty;
        }

        return null;
    }

    private boolean isEmailExisted(String email) {
        List<Student> students = studentService.findAllStudents();

        for (Student st : students) {
            if (st.getEmail().equals(email))
                return true;
        }

        return false;
    }
}
