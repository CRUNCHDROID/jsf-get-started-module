package com.crunchdroid.controller;

import com.crunchdroid.entities.Role;
import com.crunchdroid.entities.User;
import com.crunchdroid.helper.PaginationHelper;
import com.crunchdroid.services.IRoleServiceLocal;
import com.crunchdroid.services.IUserServiceLocal;
import java.io.Serializable;
import java.util.List;
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

    @EJB
    private IRoleServiceLocal roleService;

    private PaginationHelper pagination;

    private DataModel users = null;

    private Integer id;
    private Integer roleId;
    private String username;
    private String password;
    private List<Role> roles;

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
                    List<User> l = userService.findRange(getFirstItem(), getPageSize());
                    for (User u : l) {
                        System.out.println(u);
                    }
                    return new ListDataModel(l);
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Role> getRoles() {
        return roleService.findAll();
    }

    public IUserServiceLocal getUserService() {
        return userService;
    }

    public void setUserService(IUserServiceLocal userService) {
        this.userService = userService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        Role r = (Role) roleService.findById(roleId);
        System.out.println(r);
        p.setUsername(username);
        p.setPassword(password);
        p.setRole(r);
        userService.save(p);
        users = null;
        pagination = null;
        return goList();
    }

    public String goEdit(Integer id) {
        User p = (User) userService.findById(id);
        this.id = p.getId();
        this.username = p.getUsername();
        this.password = p.getPassword();
        this.roleId = p.getRole().getId();
        return "Edit";
    }

    public String update() {
        User p = new User();
        p.setId(id);
        p.setUsername(username);
        p.setPassword(password);
        p.setRole((Role) roleService.findById(roleId));
        userService.update(p);
        users = null;
        return goList();
    }

    public String goList() {
        this.id = null;
        this.username = null;
        this.password = null;
        this.roleId = null;
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
