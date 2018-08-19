package com.github.zcmee.godmodehibernate.general;

import com.github.zcmee.godmodehibernate.entities.Employee;
import com.github.zcmee.godmodehibernate.services.EmployeeService;
import com.github.zcmee.godmodehibernate.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AccessCase {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testUser(){

        Employee user = new Employee("Aldona", "Mensa", 123);
        employeeService.create(user);
    }

}
