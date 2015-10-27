package com.crunchdroid.controller;

import com.crunchdroid.entities.User;
import com.crunchdroid.helper.PaginationHelper;
import com.crunchdroid.services.IUserServiceLocal;
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
public class UserController implements Serializable {

    @EJB
    private IUserServiceLocal userService;

    private PaginationHelper pagination;

    private DataModel users = null;

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;

    public UserController() {
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(4) {
                @Override
                public int getItemsCount() {
                    return userService.count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(userService.findRange(getFirstItem(), getPageSize()));
                }
            };
        }
        return pagination;
    }

    public DataModel getUsers() {
        if (users == null) {
            getPagination().getItemsCount();
            users = getPagination().createPageDataModel();
        }
        return users;
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

    public String delete(Integer id) {
        userService.deleteById(id);
        users = null;
        pagination = null;
        return goList();
    }

    public String goCreate() {
        return "Create";
    }

    public String save() {
        User p = new User();
        p.setFirstname(firstname);
        p.setLastname(lastname);
        p.setAge(age);
        userService.save(p);
        users = null;
        pagination = null;
        return goList();
    }

    public String goEdit(Integer id) {
        User p = (User) userService.findById(id);
        this.id = p.getId();
        this.firstname = p.getFirstname();
        this.lastname = p.getLastname();
        this.age = p.getAge();
        return "Edit";
    }

    public String update() {
        User p = new User();
        p.setId(id);
        p.setFirstname(firstname);
        p.setLastname(lastname);
        p.setAge(age);
        userService.update(p);
        users = null;
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
        users = null;
        return "List";
    }

    public String next() {
        getPagination().nextPage();
        users = null;
        return "List";
    }

    public String goPage(int page) {
        getPagination().goPage(page);
        users = null;
        return "List";
    }

}
