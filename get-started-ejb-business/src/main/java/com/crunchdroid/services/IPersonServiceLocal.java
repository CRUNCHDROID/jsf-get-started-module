package com.crunchdroid.services;

import com.crunchdroid.entities.Person;
import com.crunchdroid.jms.services.util.ValidatorException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 */
@Local
public interface IPersonServiceLocal extends IService<Person> {

    public List<Person> findRange(int startPosition, int maxResult);

    public int count();

    public void save(String firstname, String lastname, Date birthDate, String email) throws ValidatorException;
}
