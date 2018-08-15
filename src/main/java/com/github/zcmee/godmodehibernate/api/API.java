package com.github.zcmee.godmodehibernate.api;

public interface API<T> {
    void create(T entity);
    T findById(Long entity);
    void delete(T entity);
}
