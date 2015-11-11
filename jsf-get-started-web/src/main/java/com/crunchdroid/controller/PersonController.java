package com.crunchdroid.controller;

import com.crunchdroid.entities.Person;
import com.crunchdroid.helper.PaginationHelper;
import com.crunchdroid.services.IPersonServiceLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author cdi420
 */
@ManagedBean
@SessionScoped
public class PersonController implements Serializable {

    @EJB
    private IPersonServiceLocal personService;

    private PaginationHelper pagination;

    private DataModel people = null;

    private Person person;

    public PersonController() {
        person = new Person();
    }

    public String delete(Integer id) {
        personService.deleteById(id);
        people = null;
        pagination = null;
        return goList();
    }

    public String goCreate() {
        return "Create";
    }

    public String save() {
        personService.save(person);
        people = null;
        pagination = null;
        return goList();
    }

    public String goEdit(Integer id) {
        person = (Person) personService.findById(id);
        return "Edit";
    }

    public String update() {
        personService.update(person);
        people = null;
        return goList();
    }

    public String goList() {
        person = new Person();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        people = null;
        return "List";
    }

    public String next() {
        getPagination().nextPage();
        people = null;
        return "List";
    }

    public String goPage(int page) {
        getPagination().goPage(page);
        people = null;
        return "List";
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(4) {
                @Override
                public int getItemsCount() {
                    return personService.count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(personService.findRange(getFirstItem(), getPageSize()));
                }
            };
        }
        return pagination;
    }

    public DataModel getPeople() {
        if (people == null) {
            getPagination().getItemsCount();
            people = getPagination().createPageDataModel();
        }
        return people;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
