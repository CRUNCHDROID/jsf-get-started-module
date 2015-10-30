package com.crunchdroid.services;

import com.crunchdroid.entities.Person;
import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 */
@Remote
public interface IPersonServiceRemote extends IService<Person> {

}
