package com.crunchdroid.controller;

import com.crunchdroid.bean.SessionBean;
import com.crunchdroid.entities.User;
import com.crunchdroid.services.IUserServiceLocal;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi420
 */
@ManagedBean
@SessionScoped
public class AuthenticationController implements Serializable {

    @EJB
    private IUserServiceLocal userService;

    private String username;
    private String password;

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

    public String login() {
        User user = userService.findByUsernamePassword(username, password);

        if (user != null) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("user", user);
            return "index";
        } else {

            return "Login";
        }

    }

    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        System.out.println("logout()");
        return "/Login";
    }

}
