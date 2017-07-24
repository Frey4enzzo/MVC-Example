package ru.juniortest.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.juniortest.model.Department;
import ru.juniortest.service.DepartmentService;
import ru.juniortest.service.DepartmentServiceImpl;

import javax.annotation.Resource;

@Controller
public class DepartmentController {

    private static final Logger logger = Logger.getLogger(DepartmentController.class);

   DepartmentService departmentService;

    @Autowired(required = true)
    @Qualifier(value = "departmentService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String listDepartments(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("listDepartments", this.departmentService.listDepartments());
        return "departments";
    }

    @RequestMapping(value = "/departments/add", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute("department") Department department) {
        if (department.getId() == 0) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }

        return "redirect:/departments";
    }

    @RequestMapping("/departments/remove/{id}")
    public String removeDepartment(@PathVariable("id") int id) {
        this.departmentService.removeDepartment(id);

        return "redirect:/departments";
    }

    @RequestMapping(value = "/departments/edit/{id}", method = RequestMethod.GET)
    public String editDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.departmentService.getDepartmentById(id));
        model.addAttribute("listDepartments", this.departmentService.listDepartments());

        return "departments";
    }

}
