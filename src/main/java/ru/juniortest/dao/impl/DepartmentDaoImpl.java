package ru.juniortest.dao.impl;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.juniortest.dao.DepartmentDao;
import ru.juniortest.model.Department;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    private final static Logger logger = Logger.getLogger(DepartmentDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addDepartment(Department department) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(department);
        logger.debug("Prepare department to add successfully. Department details: " + department);
    }

    public void updateDepartment(Department department) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(department);
        logger.debug("Prepare department to update successfully. Department details: " + department);
    }

    public void removeDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department department = (Department) session.load(Department.class, new Integer(id));
        if (null != department) {
            session.delete(department);
            logger.info("Prepare department to delete successfully. Department details: " + department);
        }
    }

    public Department getDepartmentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department department = (Department) session.load(Department.class, new Integer(id));
        logger.debug("Department loaded successfully. Department details: " + department);
        return department;
    }

    @SuppressWarnings("uncheked")
    public List<Department> listDepartments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("from Department ").list();
        for (Department department : departmentList) {
            logger.debug("Department List::" + department);
        }
        return departmentList;
    }
}
