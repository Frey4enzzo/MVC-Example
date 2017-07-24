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
import ru.juniortest.model.Employee;
import ru.juniortest.service.EmployeeService;

@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    EmployeeService employeeService;

    @Autowired
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", employeeService.listEmployees());
        return "employees";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }

        return "redirect:/employees";
    }

    @RequestMapping("/employees/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id) {
        this.employeeService.removeEmployee(id);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }
}
