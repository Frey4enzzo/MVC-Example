package ru.juniortest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.juniortest.dao.EmployeeDao;
import ru.juniortest.model.Employee;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void removeEmployee(int id) {
        this.employeeDao.removeEmployee(id);
    }

    @Transactional
    public Employee getEmployeeById(int id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDao.listEmployees();
    }
}
