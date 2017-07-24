package ru.juniortest.controllers;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.juniortest.model.Department;

@Controller
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainpage(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/employees")
    public ModelAndView employeeHome() {
        return new ModelAndView("employees");
    }


}
