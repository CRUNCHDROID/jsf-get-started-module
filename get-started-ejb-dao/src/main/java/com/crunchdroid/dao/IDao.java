package com.crunchdroid.dao;

import com.crunchdroid.util.LogSQL;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
public interface IDao<E> {
    
    public EntityManager getEntityManager();
    public Class<E> getEntity();

    public void save(E entity);

    public void update(E entity);

    default E findById(Integer id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery((Class<E>) getEntity());
        Root<E> r = cq.from((Class<E>) getEntity());
        cq.select(r).where(cb.equal(r.get("id"), id));
        TypedQuery<E> q = getEntityManager().createQuery(cq);

        LogSQL.getSqlString(getEntityManager(), q);
        return (E) q.getSingleResult();
    }

    public List<E> findAll();

    public void delete(E entity);

    public void deleteById(Integer id);

}
