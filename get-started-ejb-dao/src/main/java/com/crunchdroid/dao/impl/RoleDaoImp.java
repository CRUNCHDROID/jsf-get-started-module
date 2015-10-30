package com.crunchdroid.dao.impl;

import com.crunchdroid.dao.IDaoRoleLocal;
import com.crunchdroid.dao.IDaoRoleRemote;
import com.crunchdroid.entities.Role;
import com.crunchdroid.util.LogSQL;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Riad YOUSFI
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleDaoImp implements IDaoRoleLocal, IDaoRoleRemote, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Role> findAll() {
        CriteriaQuery<Role> cq = em.getCriteriaBuilder().createQuery(Role.class);
        Root<Role> r = cq.from(Role.class);
        cq.select(r);
        Query q = em.createQuery(cq);
        LogSQL.getSqlString(em, q);
        return q.getResultList();
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

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Role> getEntity() {
        return Role.class;
    }

}
