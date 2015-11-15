package com.crunchdroid.controller;

import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IPersonServiceLocal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

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
    private Person selectedPerson;

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

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public void showPersonView() {
        System.out.println("<<<<<<<<<<<<<<<  TEST  >>>>>>>>>>>>>>>>>>>>");
        Map<String,Object> options = new HashMap();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("Edit", options, null);
    }

}
