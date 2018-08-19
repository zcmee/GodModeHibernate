package com.github.zcmee.godmodehibernate.api;

import com.github.zcmee.godmodehibernate.entities.Employee;

public interface CustomInterfaceEmployee {
    Employee findByName(String name);
}
