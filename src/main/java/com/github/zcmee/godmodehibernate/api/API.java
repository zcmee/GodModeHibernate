package com.github.zcmee.godmodehibernate.api;

import java.util.List;

public interface API<T> {
    void create(T entity);
    List<T> findAll();
    T findById(Long entity);
    void delete(T entity);
}
