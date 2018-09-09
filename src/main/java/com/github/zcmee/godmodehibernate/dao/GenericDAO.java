package com.github.zcmee.godmodehibernate.dao;


import com.github.zcmee.godmodehibernate.api.API;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDAO<T extends Serializable> implements API<T>, BaseDAO<T> {

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

    @Override
    public T findByField(String fieldName, Object fieldValue) {
        CriteriaBuilder builder = getCriteria();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);

        criteriaQuery.select(root)
                .where(builder.equal(root.get(fieldName), fieldValue));

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    protected CriteriaBuilder getCriteria() {
        return entityManager.getCriteriaBuilder();
    }

}
