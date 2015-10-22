package com.crunchdroid.dao;

import com.crunchdroid.entities.Person;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
