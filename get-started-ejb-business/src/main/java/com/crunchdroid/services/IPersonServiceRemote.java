package com.crunchdroid.services;

import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Remote
public interface IPersonServiceRemote<E> extends IService<E> {

}
