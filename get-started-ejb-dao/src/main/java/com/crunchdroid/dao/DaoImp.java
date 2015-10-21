package com.crunchdroid.dao;

import com.crunchdroid.entities.Person;
import java.io.Serializable;
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
public class DaoImp implements IDaoLocal, IDaoRemote, Serializable {

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Person person) {
        em.persist(person);
    }

}
