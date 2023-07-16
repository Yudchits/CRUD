package by.yudchits.uiip.crud_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/main")
    public String showAllStudents(){
        return "all-information";
    }
}
