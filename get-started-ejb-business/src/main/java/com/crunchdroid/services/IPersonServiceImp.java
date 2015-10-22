package com.crunchdroid.services;

import com.crunchdroid.dao.IDaoLocal;
import com.crunchdroid.entities.Person;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Riad YOUSFI
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class IPersonServiceImp implements IServiceLocal<Person>, IServiceRemote<Person>, Serializable {

    @EJB
    private IDaoLocal<Person> dao;

    @Override
    public void save(Person person) {
        dao.save(person);
    }

    @Override
    public void update(Person person) {
        dao.update(person);
    }

    @Override
    public Person find(Integer id) {
        return dao.find(id);
    }

    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Person person) {
        dao.delete(person);
    }

}
