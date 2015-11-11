package com.crunchdroid.controller;

import com.crunchdroid.entities.Person;
import com.crunchdroid.helper.PaginationHelper;
import com.crunchdroid.jms.services.util.ValidatorException;
import com.crunchdroid.services.IPersonServiceLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private Integer id;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String email;
    private Integer age;

    public PersonController() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        try {
            personService.save(firstname, lastname, birthDate, email);
        } catch (ValidatorException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        people = null;
        pagination = null;
        return goList();
    }

    public String goEdit(Integer id) {
        Person p = (Person) personService.findById(id);
        this.id = p.getId();
        this.firstname = p.getFirstname();
        this.lastname = p.getLastname();
        this.age = p.getAge();
        return "Edit";
    }

    public String update() {
        Person p = new Person();
        p.setId(id);
        p.setFirstname(firstname);
        p.setLastname(lastname);
        personService.update(p);
        people = null;
        return goList();
    }

    public String goList() {
        this.id = null;
        this.firstname = null;
        this.lastname = null;
        this.age = null;
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

}
