package com.crunchdroid.services.impl;

import com.crunchdroid.dao.IDaoRoleLocal;
import com.crunchdroid.entities.Role;
import com.crunchdroid.services.IRoleServiceLocal;
import com.crunchdroid.services.IRoleServiceRemote;
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
public class IRoleServiceImp implements IRoleServiceLocal<Role>, IRoleServiceRemote<Role>, Serializable {

    @EJB
    private IDaoRoleLocal<Role> dao;

    @Override
    public void save(Role role) {
        dao.save(role);
    }

    @Override
    public void update(Role role) {
        dao.update(role);
    }

    @Override
    public Role findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Role role) {
        dao.delete(role);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Role> findRange(int startPosition, int maxResult) {
        return dao.findRange(startPosition, maxResult);
    }

    @Override
    public int count() {
        return dao.count();
    }

}
