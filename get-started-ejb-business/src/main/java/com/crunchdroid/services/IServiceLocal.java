/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchdroid.services;

import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 * @param <E> entity
 */
@Local
public interface IServiceLocal<E> extends IService<E> {

}
