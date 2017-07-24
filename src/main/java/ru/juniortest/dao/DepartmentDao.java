package ru.juniortest.dao;


import ru.juniortest.model.Department;

import java.util.List;

public interface DepartmentDao {

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public void removeDepartment(int id);

    public Department getDepartmentById(int id);

    public List<Department> listDepartments();
}
