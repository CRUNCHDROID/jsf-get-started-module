/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchdroid.services;

import java.util.List;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
public interface IService<E> {

    public void save(E entity);

    public void update(E entity);

    public E find(Integer id);

    public List<E> findAll();

    public void delete(E entity);

}
