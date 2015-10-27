package com.crunchdroid.services;

import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Remote
public interface IUserServiceRemote<E> extends IService<E> {

}
