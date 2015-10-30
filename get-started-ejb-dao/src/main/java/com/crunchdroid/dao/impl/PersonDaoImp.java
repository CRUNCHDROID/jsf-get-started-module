package com.crunchdroid.dao.impl;

import com.crunchdroid.dao.IDaoPersonLocal;
import com.crunchdroid.dao.IDaoPersonRemote;
import com.crunchdroid.entities.Person;
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
public class PersonDaoImp implements IDaoPersonLocal, IDaoPersonRemote, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Person> findAll() {
        CriteriaQuery<Person> cq = em.getCriteriaBuilder().createQuery(Person.class);
        Root<Person> r = cq.from(Person.class);
        cq.select(r);
        Query q = em.createQuery(cq);
        LogSQL.getSqlString(em, q);
        return q.getResultList();
    }

    @Override
    public List<Person> findRange(int startPosition, int maxResult) {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(Person.class));
        Query query = em.createQuery(criteriaQuery).setFirstResult(startPosition).setMaxResults(maxResult);
        return query.getResultList();
    }

    @Override
    public int count() {
        CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(em.getCriteriaBuilder().count(root));
        Query query = em.createQuery(criteriaQuery);
        return ((Long) query.getSingleResult()).intValue();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Person> getEntity() {
        return Person.class;
    }

}
