package com.crunchdroid.dao;

import com.crunchdroid.entities.User;
import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 */
@Remote
public interface IDaoUserRemote extends IDao<User> {

}
