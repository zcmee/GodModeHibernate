package com.github.zcmee.godmodehibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<T> implements DAO<T> {
    @PersistenceContext
    protected EntityManager entityManager;
    private Class<T> clazz;

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

    @Override
    public void deleteById(Long entityId) {
        T entity = findById(entityId);
        entityManager.remove(entity);
    }
}
