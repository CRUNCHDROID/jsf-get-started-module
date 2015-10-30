package com.crunchdroid.dao;

import com.crunchdroid.entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 */
@Local
public interface IDaoUserLocal extends IDao<User> {

    public List<User> findRange(int startPosition, int maxResult);

    public int count();

    public User findByUsernamePassword(String username, String password);
}
