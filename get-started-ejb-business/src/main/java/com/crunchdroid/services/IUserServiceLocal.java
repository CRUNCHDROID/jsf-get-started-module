package com.crunchdroid.services;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Local
public interface IUserServiceLocal<E> extends IService<E> {

    public List<E> findRange(int startPosition, int maxResult);

    public int count();
}
