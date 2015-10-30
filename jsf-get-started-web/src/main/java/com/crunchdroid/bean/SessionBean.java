package com.crunchdroid.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
public class SessionBean {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

}
