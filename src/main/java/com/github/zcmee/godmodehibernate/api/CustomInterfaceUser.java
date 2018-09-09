package com.github.zcmee.godmodehibernate.api;

import com.github.zcmee.godmodehibernate.entities.User;

public interface CustomInterfaceUser {
    User findByFirstName(String name);
}
