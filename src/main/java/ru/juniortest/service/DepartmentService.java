package ru.juniortest.service;

import ru.juniortest.model.Department;
import java.util.List;


public interface DepartmentService {

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public void removeDepartment(int id);

    public Department getDepartmentById(int id);

    public List<Department> listDepartments();
}
