package com.github.zcmee.godmodehibernate.dao;

import com.github.zcmee.godmodehibernate.api.CustomInterfaceUser;
import com.github.zcmee.godmodehibernate.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends GenericDAO<User> implements CustomInterfaceUser {

    @Override
    public User findByFirstName(String name) {
        return findByField("firstName", name);
    }

}