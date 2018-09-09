package com.github.zcmee.godmodehibernate.dao;

public interface BaseDAO<T> {
    T findByField(String fieldName, Object fieldValue);
}
