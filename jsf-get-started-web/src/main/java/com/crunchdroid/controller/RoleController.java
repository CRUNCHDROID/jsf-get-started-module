package com.crunchdroid.controller;

import com.crunchdroid.entities.Role;
import com.crunchdroid.helper.PaginationHelper;
import com.crunchdroid.services.IRoleServiceLocal;
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
public class RoleController implements Serializable {

    @EJB
    private IRoleServiceLocal roleService;

    private PaginationHelper pagination;

    private DataModel roles = null;

    private Integer id;
    private String name;

    public RoleController() {
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(4) {
                @Override
                public int getItemsCount() {
                    return roleService.count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(roleService.findRange(getFirstItem(), getPageSize()));
                }
            };
        }
        return pagination;
    }

    public DataModel getRoles() {
        if (roles == null) {
            getPagination().getItemsCount();
            roles = getPagination().createPageDataModel();
        }
        return roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String delete(Integer id) {
        roleService.deleteById(id);
        roles = null;
        pagination = null;
        return goList();
    }

    public String goCreate() {
        return "Create";
    }

    public String save() {
        Role r = new Role();
        r.setName(name);
        roleService.save(r);
        roles = null;
        pagination = null;
        return goList();
    }

    public String goEdit(Integer id) {
        Role r = (Role) roleService.findById(id);
        this.id = r.getId();
        this.name = r.getName();
        return "Edit";
    }

    public String update() {
        Role r = new Role();
        r.setId(id);
        r.setName(name);
        roleService.update(r);
        roles = null;
        return goList();
    }

    public String goList() {
        this.id = null;
        this.name = null;
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        roles = null;
        return "List";
    }

    public String next() {
        getPagination().nextPage();
        roles = null;
        return "List";
    }

    public String goPage(int page) {
        getPagination().goPage(page);
        roles = null;
        return "List";
    }

}
