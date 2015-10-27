package com.crunchdroid.dao.impl;

import com.crunchdroid.dao.IDaoUserLocal;
import com.crunchdroid.dao.IDaoUserRemote;
import com.crunchdroid.entities.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
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
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User findById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> r = query.from(User.class);
        query.select(r).where(builder.equal(r.get("id"), id));
        System.out.println(query.toString());

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public List<User> findAll() {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> r = query.from(User.class);
        query.select(r);
        System.out.println(query.toString());

        return em.createQuery(query).getResultList();
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void deleteById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<User> delete = builder.createCriteriaDelete(User.class);
        Root<User> r = delete.from(User.class);
        delete.where(builder.equal(r.get("id"), id));
        System.out.println(delete.toString());

        em.createQuery(delete).executeUpdate();
    }

    @Override
    public List<User> findRange(int startPosition, int maxResult) {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(User.class));
        return em.createQuery(criteriaQuery).setFirstResult(startPosition).setMaxResults(maxResult).getResultList();
    }

    @Override
    public int count() {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        Root<User> r = criteriaQuery.from(User.class);
        criteriaQuery.select(em.getCriteriaBuilder().count(r));
        return ((Long) em.createQuery(criteriaQuery).getSingleResult()).intValue();
    }

}
