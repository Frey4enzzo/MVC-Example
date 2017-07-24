package ru.juniortest.dao.impl;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.juniortest.dao.EmployeeDao;
import ru.juniortest.model.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("Employee add successfully. Employee details: " + employee);
    }

    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        logger.info("Employee update successfully. Employee details: " + employee);
    }

    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        if (null != employee) {
            session.delete(employee);
        }
        logger.info("Employee deleted successfully. Employee details: " + employee);
    }

    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        logger.info("Employee loaded successfully. Employee details: " + employee);
        return employee;
    }

    @SuppressWarnings("uncheked")
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee ").list();
        for (Employee employee : employeeList) {
            logger.info("Employee List::" + employee);
        }
        return employeeList;
    }
}
