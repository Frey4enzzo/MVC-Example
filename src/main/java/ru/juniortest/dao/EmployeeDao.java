package ru.juniortest.dao;

import ru.juniortest.model.Department;
import ru.juniortest.model.Employee;
import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(int id);

    public Employee getEmployeeById(int id);

    public List<Employee> listEmployees();

    public List<Employee> findEmployeeByFirstOrLastname(String searchText);

}
