package com.crunchdroid.services.impl;

import com.crunchdroid.dao.IDaoPersonLocal;
import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IPersonServiceLocal;
import com.crunchdroid.services.IPersonServiceRemote;
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
public class IPersonServiceImp implements IPersonServiceLocal<Person>, IPersonServiceRemote<Person>, Serializable {

    @EJB
    private IDaoPersonLocal<Person> dao;

    @Override
    public void save(Person person) {
        dao.save(person);
    }

    @Override
    public void update(Person person) {
        dao.update(person);
    }

    @Override
    public Person findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Person person) {
        dao.delete(person);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Person> findRange(int startPosition, int maxResult) {
        return dao.findRange(startPosition, maxResult);
    }

    @Override
    public int count() {
        return dao.count();
    }

}
