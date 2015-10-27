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

    public E findById(Integer id);

    public List<E> findAll();

    public void delete(E entity);

    public void deleteById(Integer id);

}
