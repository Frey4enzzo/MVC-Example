package ru.juniortest.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.PropertyValuesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.juniortest.model.Department;
import ru.juniortest.model.Employee;
import ru.juniortest.service.DepartmentService;
import ru.juniortest.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

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

    @RequestMapping("/employees/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id) {
        this.employeeService.removeEmployee(id);
        logger.info("Employee removed successfully");

        return "redirect:/employees";
    }


    @RequestMapping(value = "addemployee", method = RequestMethod.GET)
    public String addEmployeePage(Model model) {
        model.addAttribute("employee", new Employee());

        return "addemployee";
    }


    @RequestMapping(value = "addemployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        logger.info("Employee added successfully. Employee: " + employee);

        return "redirect:/employees";
    }

    @ModelAttribute("departmentsList")
    public List<Department> departmentList() {
        List<Department> departments = departmentService.listDepartments();
        logger.debug("departmentList generate successfully");

        return departments;
    }

    // Don't working
//    @RequestMapping("searchEmployee")
//    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName, BindingResult result) {
//        logger.info("Searching the Employee. Employee names: " + searchName);
//        List<Employee> employeeList = employeeService.findEmployeeByFirstOrLastname(searchName);
//
//        return new ModelAndView("employees", "employee", employeeList);
//    }

    // Don't working
    @RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable("id") int id, Model model) {
        logger.debug("Received request to update employee");
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }

}
