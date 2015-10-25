package com.crunchdroid.dao;

import java.util.List;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
public interface IDao<E> {

    public void save(E entity);

    public void update(E entity);

    public E find(Integer id);

    public List<E> findAll();

    public void delete(E entity);

    public void delete(Integer id);

    public List<E> findRange(int startPosition, int maxResult);
    
    public int count();
}
