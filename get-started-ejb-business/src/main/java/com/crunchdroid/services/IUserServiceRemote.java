package com.crunchdroid.services;

import com.crunchdroid.entities.User;
import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 */
@Remote
public interface IUserServiceRemote extends IService<User> {

}
