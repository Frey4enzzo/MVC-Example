package ru.juniortest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.juniortest.dao.DepartmentDao;
import ru.juniortest.model.Department;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

//    @Autowired
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional
    public void addDepartment(Department department) {
        this.departmentDao.addDepartment(department);
    }

    @Transactional
    public void updateDepartment(Department department) {
        this.departmentDao.updateDepartment(department);
    }

    @Transactional
    public void removeDepartment(int id) {
        this.departmentDao.removeDepartment(id);
    }

    @Transactional
    public Department getDepartmentById(int id) {
        return this.departmentDao.getDepartmentById(id);
    }

    @Transactional
    public List<Department> listDepartments() {
        return this.departmentDao.listDepartments();
    }
}
