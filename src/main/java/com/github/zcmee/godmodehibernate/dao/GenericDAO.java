package com.github.zcmee.godmodehibernate.dao;

import com.github.zcmee.godmodehibernate.api.API;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDAO<T extends Serializable> implements API<T> {
    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> clazz;

    public GenericDAO() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T findById(Long entityId) {
        return entityManager.find(clazz, entityId);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

}
