package ru.juniortest.dao.impl;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.juniortest.dao.EmployeeDao;
import ru.juniortest.model.Department;
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
        logger.debug("Prepare employee to add successfully. Employee details: " + employee);
    }

    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        logger.debug("Prepare employee to update successfully. Employee details: " + employee);
    }

    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        if (null != employee) {
            session.delete(employee);
            logger.info("Prepare employee to delete successfully. Employee details: " + employee);
        }
    }

    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        logger.debug("Employee loaded successfully. Employee details: " + employee);
        return employee;
    }

    @SuppressWarnings("uncheked")
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee order by id ").list();
        for (Employee employee : employeeList) {
            logger.debug("Employee List::" + employee);
        }
        return employeeList;
    }

    @SuppressWarnings("uncheked")
    public List<Employee> findEmployeeByFirstOrLastname(String searchText) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Employee.class);

        Criterion partOfFirstname = Restrictions.like("firstname", searchText, MatchMode.ANYWHERE);
        Criterion partOfLastname = Restrictions.like("lastname", searchText, MatchMode.ANYWHERE);
        LogicalExpression expression = Restrictions.or(partOfFirstname, partOfLastname);

        logger.debug("Prepare employees list search by firstname or lastname");
        for (Object employee : criteria.add(expression).list()) {
            logger.debug("Employee list::" + employee);
        }
        return criteria.add(expression).list();
    }
}
