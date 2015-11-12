package com.crunchdroid.controller;

import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IPersonServiceLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@ManagedBean(name = "pfPersonController")
@ViewScoped
public class PrimefacesPersonController implements Serializable {

    @EJB
    private IPersonServiceLocal personService;
    private List<Person> people;

    public PrimefacesPersonController() {
    }

    @PostConstruct
    public void init() {
        people = personService.findAll();
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

}
