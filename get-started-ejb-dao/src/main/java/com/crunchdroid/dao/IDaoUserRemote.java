package com.crunchdroid.dao;

import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Remote
public interface IDaoUserRemote<E> extends IDao<E> {

}
