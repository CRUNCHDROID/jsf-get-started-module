package com.crunchdroid.services;

import com.crunchdroid.entities.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 */
@Local
public interface IRoleServiceLocal extends IService<Role> {

    public List<Role> findRange(int startPosition, int maxResult);

    public int count();
}
