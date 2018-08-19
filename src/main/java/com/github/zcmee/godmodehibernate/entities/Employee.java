package com.github.zcmee.godmodehibernate.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {



    private Long id;
    @Access(AccessType.FIELD)
    private String firstName;
    private String lastName;
    private double salary;

    public Employee() {

    }

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    @Id
    @GeneratedValue
    public Long getId() {
        System.out.println("get po id");
        return id;
    }

    public void setId(Long id) {
        System.out.println("set po id");
        this.id = id;
    }

    public String getFirstName() {
        System.out.println("get po fi");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("set po fi");
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println("get po lb");
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
/*
  BEZ ACCESSTYPE.FIELD
    get po id
    get po fi
    get po lb
    set po id
    get po id
    get po fi
    get po lb
*/
/*
Z  ACCESSTYPE.FIELD
    get po id
    get po lb
    set po id
    get po id
    get po lb
*/