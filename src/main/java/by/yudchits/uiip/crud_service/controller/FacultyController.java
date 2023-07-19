package by.yudchits.uiip.crud_service.controller;

import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/add-faculty")
    public String addNewFaculty(Model model){
        model.addAttribute("faculty", new Faculty());

        return "add-update-faculty";
    }

    @RequestMapping("/save-update-faculty")
    public String saveOrUpdateFaculty(@Valid @ModelAttribute("faculty") Faculty faculty, BindingResult bindingResult){
        List<Faculty> faculties = facultyService.findAllFaculties();

        for (Faculty f : faculties) {
            if(f.getName().equals(faculty.getName())){
                bindingResult.rejectValue("name", "error.name", "Such faculty already exists");
                return "add-update-faculty";
            }
        }

        facultyService.saveOrUpdateFaculty(faculty);
        return "redirect:/main";
    }
}
