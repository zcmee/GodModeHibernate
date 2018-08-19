package com.github.zcmee.godmodehibernate.services;

import com.github.zcmee.godmodehibernate.api.API;
import com.github.zcmee.godmodehibernate.api.CustomInterfaceEmployee;
import com.github.zcmee.godmodehibernate.api.CustomInterfaceUser;
import com.github.zcmee.godmodehibernate.dao.EmployeeDAO;
import com.github.zcmee.godmodehibernate.dao.UserDAO;
import com.github.zcmee.godmodehibernate.entities.Employee;
import com.github.zcmee.godmodehibernate.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService implements API<Employee>, CustomInterfaceEmployee {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public Employee findById(Long entityId) {
        return employeeDAO.findById(entityId);
    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public Employee findByName(String name) {
        return null;
    }
}
