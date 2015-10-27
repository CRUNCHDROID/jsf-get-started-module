package com.crunchdroid.dao;

import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Remote
public interface IDaoPersonRemote<E> extends IDao<E> {

}
