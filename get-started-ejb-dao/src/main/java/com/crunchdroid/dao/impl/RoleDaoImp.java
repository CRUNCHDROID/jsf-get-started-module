package com.crunchdroid.dao.impl;

import com.crunchdroid.dao.IDaoRoleLocal;
import com.crunchdroid.dao.IDaoRoleRemote;
import com.crunchdroid.entities.Role;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class RoleDaoImp implements IDaoRoleLocal<Role>, IDaoRoleRemote<Role>, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Role role) {
        em.persist(role);
    }

    @Override
    public void update(Role role) {
        em.merge(role);
    }

    @Override
    public Role findById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> r = query.from(Role.class);
        query.select(r).where(builder.equal(r.get("id"), id));
        System.out.println(query.toString());

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public List<Role> findAll() {
        CriteriaQuery<Role> query = em.getCriteriaBuilder().createQuery(Role.class);
        Root<Role> r = query.from(Role.class);
        query.select(r);
        System.out.println(query.toString());
        
        return em.createQuery(query).getResultList();
    }

    @Override
    public void delete(Role role) {
        em.remove(role);
    }

    @Override
    public void deleteById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<Role> delete = builder.createCriteriaDelete(Role.class);
        Root<Role> r = delete.from(Role.class);
        delete.where(builder.equal(r.get("id"), id));
        System.out.println(delete.toString());

        em.createQuery(delete).executeUpdate();
    }

    @Override
    public List<Role> findRange(int startPosition, int maxResult) {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Role.class));
        return em.createQuery(criteriaQuery).setFirstResult(startPosition).setMaxResults(maxResult).getResultList();
    }

    @Override
    public int count() {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        Root<Role> r = criteriaQuery.from(Role.class);
        criteriaQuery.select(em.getCriteriaBuilder().count(r));
        return ((Long) em.createQuery(criteriaQuery).getSingleResult()).intValue();
    }

}
