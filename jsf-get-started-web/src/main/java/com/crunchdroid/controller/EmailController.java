package com.crunchdroid.controller;

import com.crunchdroid.bean.EmailSessionBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.MessagingException;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@ManagedBean
@SessionScoped
public class EmailController implements Serializable {

    @EJB
    EmailSessionBean emailSender;

    private String to;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String sendEmail() {

        try {
            emailSender.send(to, subject, body);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Email";
    }

}
