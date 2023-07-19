package by.yudchits.uiip.crud_service.controller;

import by.yudchits.uiip.crud_service.entity.Faculty;
import by.yudchits.uiip.crud_service.service.FacultyService;
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
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/add-faculty")
    public String addNewFaculty(Model model) {
        model.addAttribute("faculty", new Faculty());

        return "add-update-faculty";
    }

    @RequestMapping("/update-faculty-details")
    public String updateFaculty(@RequestParam("id") long id, Model model) {
        Faculty faculty = facultyService.findFacultyById(id);

        model.addAttribute("faculty", faculty);

        return "add-update-faculty";
    }

    @RequestMapping("/save-update-faculty")
    public String saveOrUpdateFaculty(@Valid @ModelAttribute("faculty") Faculty faculty, BindingResult bindingResult) {
        boolean isFacultyNameExisted = false;

        if (faculty.getId() != 0) {
            Faculty oldFaculty = facultyService.findFacultyById(faculty.getId());

            if (!oldFaculty.getName().equals(faculty.getName())) {
                isFacultyNameExisted = isFacultyNameExisted(faculty.getName());
            }
        } else {
            isFacultyNameExisted = isFacultyNameExisted(faculty.getName());
        }

        if (isFacultyNameExisted) {
            bindingResult.rejectValue("name", "error.name", "Such faculty already exists");
            return "add-update-faculty";
        }

        if (bindingResult.hasErrors()) {
            return "add-update-faculty";
        } else {
            facultyService.saveOrUpdateFaculty(faculty);
            return "redirect:/main";
        }
    }

    private boolean isFacultyNameExisted(String facultyName) {
        List<Faculty> faculties = facultyService.findAllFaculties();

        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName))
                return true;
        }

        return false;
    }

    @RequestMapping("/delete-faculty")
    public String deleteFaculty(@RequestParam("id") long id) {
        facultyService.deleteFacultyById(id);

        return "redirect:/main";
    }
}
