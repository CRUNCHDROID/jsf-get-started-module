package com.crunchdroid.dao;

import com.crunchdroid.entities.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riad YOUSFI
 */
@Local
public interface IDaoPersonLocal extends IDao<Person> {

    public List<Person> findRange(int startPosition, int maxResult);

    public int count();
}
