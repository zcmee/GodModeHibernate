package com.github.zcmee.godmodehibernate.services;

import com.github.zcmee.godmodehibernate.api.API;
import com.github.zcmee.godmodehibernate.api.CustomInterfaceUser;
import com.github.zcmee.godmodehibernate.dao.UserDAO;
import com.github.zcmee.godmodehibernate.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements API<User>, CustomInterfaceUser {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(Long entityId) {
        return userDAO.findById(entityId);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }

}
