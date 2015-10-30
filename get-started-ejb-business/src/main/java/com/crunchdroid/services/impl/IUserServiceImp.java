package com.crunchdroid.services.impl;

import com.crunchdroid.dao.IDaoUserLocal;
import com.crunchdroid.entities.User;
import com.crunchdroid.services.IUserServiceLocal;
import com.crunchdroid.services.IUserServiceRemote;
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
public class IUserServiceImp implements IUserServiceLocal, IUserServiceRemote, Serializable {

    @EJB
    private IDaoUserLocal dao;

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public User findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<User> findRange(int startPosition, int maxResult) {
        return dao.findRange(startPosition, maxResult);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public User findByUsernamePassword(String username, String password) {
        return dao.findByUsernamePassword(username, password);
    }

}
