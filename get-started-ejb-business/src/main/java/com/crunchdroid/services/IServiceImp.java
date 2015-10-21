package com.crunchdroid.services;

import com.crunchdroid.dao.IDaoLocal;
import com.crunchdroid.entities.Person;
import java.io.Serializable;
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
public class IServiceImp implements IServiceLocal, IServiceRemote, Serializable {

    @EJB
    private IDaoLocal dao;

    @Override
    public void save(Person person) {
        dao.save(person);
    }

}
