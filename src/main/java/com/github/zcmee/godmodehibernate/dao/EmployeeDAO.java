package com.github.zcmee.godmodehibernate.dao;

import com.github.zcmee.godmodehibernate.api.CustomInterfaceEmployee;
import com.github.zcmee.godmodehibernate.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO extends GenericDAO<Employee> implements CustomInterfaceEmployee {

    @Override
    public Employee findByName(String name) {
        return entityManager.find(Employee.class, name);
    }
}
