package com.crunchdroid.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Local
public interface IDaoRoleLocal<E> extends IDao<E> {

    public List<E> findRange(int startPosition, int maxResult);

    public int count();
}
