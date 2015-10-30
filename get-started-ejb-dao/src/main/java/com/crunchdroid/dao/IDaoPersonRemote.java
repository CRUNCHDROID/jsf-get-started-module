package com.crunchdroid.dao;

import com.crunchdroid.entities.Person;
import javax.ejb.Remote;

/**
 *
 * @author Riad YOUSFI
 */
@Remote
public interface IDaoPersonRemote extends IDao<Person> {

}
