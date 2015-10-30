package com.crunchdroid.dao;

import com.crunchdroid.entities.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 */
@Local
public interface IDaoRoleLocal extends IDao<Role> {

    public List<Role> findRange(int startPosition, int maxResult);

    public int count();
}
