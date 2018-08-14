package com.github.zcmee.godmodehibernate.dao;

public interface DAO<T> {
    void create(T entity);
    T findById(Long entity);
    void delete(T entity);
    void deleteById(Long entityId);
}
