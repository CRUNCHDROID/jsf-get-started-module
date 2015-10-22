package com.crunchdroid.controller;

import com.crunchdroid.services.IServiceLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cdi420
 */
@ManagedBean
@SessionScoped
public class PersonController implements Serializable {

    @EJB
    private IServiceLocal service;

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;

    public PersonController() {
    }

    public PersonController(String firstname, String lastname, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void save() {
        service.save(this);
    }

}
