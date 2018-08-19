package com.github.zcmee.godmodehibernate.controllers;

import com.github.zcmee.godmodehibernate.dao.UserDAO;
import com.github.zcmee.godmodehibernate.entities.Employee;
import com.github.zcmee.godmodehibernate.entities.User;
import com.github.zcmee.godmodehibernate.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;
    private final EntityManagerFactory entityManagerFactory;

    public UserController(UserService userService, EntityManagerFactory entityManagerFactory) {
        this.userService = userService;
        this.entityManagerFactory = entityManagerFactory;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("dirtychackingtest/{id}")
    public void dirtychackingtestById(@PathVariable Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        Employee employee = new Employee("Tomasz", "terca", 69);
        try {
            entityManager.persist(employee);
            user.setLastName("Zawada");
            employee.setLastName("Tercconi");
            user.setFirstName("Baramba");
            employee.setFirstName("Yonathannn");
            entityManager.getTransaction().commit();
        }catch(Exception ex) {
            System.out.println("poszedl ex");
            entityManager.getTransaction().rollback();
        }

    }

//Hibernate:
//    select
//    user0_.id as id1_1_0_,
//    user0_.email as email2_1_0_,
//    user0_.first_name as first_na3_1_0_,
//    user0_.last_name as last_nam4_1_0_
//            from
//    users user0_
//    where
//    user0_.id=?
//    get po id
//    get po lb
//    Hibernate:
//    insert
//            into
//    employee
//            (first_name, last_name, salary)
//    values
//            (?, ?, ?)
//    set po id
//    set po fi
//    get po id
//    get po lb
//    Hibernate:
//    update
//            users
//    set
//    email=?,
//    first_name=?,
//    last_name=?
//    where
//    id=?
//    Hibernate:
//    update
//            employee
//    set
//    first_name=?,
//    last_name=?,
//    salary=?
//    where
//    id=?


}
