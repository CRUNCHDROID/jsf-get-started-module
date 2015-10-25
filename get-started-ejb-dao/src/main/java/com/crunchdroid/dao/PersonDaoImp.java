package com.crunchdroid.dao;

import com.crunchdroid.entities.Person;
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
public class PersonDaoImp implements IDaoLocal<Person>, IDaoRemote<Person>, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public void update(Person entity) {
        em.merge(entity);
    }

    @Override
    public Person find(Integer id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        String query = "SELECT p FROM Person p";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void delete(Person person) {
        em.remove(person);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Person p WHERE p.id = :id";
        Query query = em.createQuery(sql);
        query.setParameter("id", id).executeUpdate();
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

}
