package com.crunchdroid.dao.impl;

import com.crunchdroid.dao.IDaoUserLocal;
import com.crunchdroid.dao.IDaoUserRemote;
import com.crunchdroid.entities.Role;
import com.crunchdroid.entities.User;
import com.crunchdroid.util.LogSQL;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author Riad YOUSFI
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserDaoImp implements IDaoUserLocal<User>, IDaoUserRemote<User>, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> u = cq.from(User.class);
        Join<User, Role> r = u.join("role", JoinType.LEFT);
        cq.multiselect(u, r.get("name"));
        TypedQuery<User> q = em.createQuery(cq);
        LogSQL.getSqlString(getEntityManager(), q);
        return q.getResultList();
    }

    @Override
    public List<User> findRange(int startPosition, int maxResult) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        Root<User> u = cq.from(User.class);
        cq.select(u);
        TypedQuery<User> q = em.createQuery(cq).setFirstResult(startPosition).setMaxResults(maxResult);

        LogSQL.getSqlString(getEntityManager(), q);

        return q.getResultList();
    }

    @Override
    public int count() {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        Root<User> r = criteriaQuery.from(User.class);
        criteriaQuery.select(em.getCriteriaBuilder().count(r));
        return ((Long) em.createQuery(criteriaQuery).getSingleResult()).intValue();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<User> getEntity() {
        return User.class;
    }

}
