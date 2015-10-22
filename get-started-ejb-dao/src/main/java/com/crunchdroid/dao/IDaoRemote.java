package com.crunchdroid.dao;

import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Remote
public interface IDaoRemote<E> extends IDao<E> {

}
