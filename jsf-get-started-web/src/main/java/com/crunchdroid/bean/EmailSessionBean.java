package com.crunchdroid.bean;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@Stateless
@LocalBean
public class EmailSessionBean {

    @Resource(lookup = "mail/GmailSession")
    private Session mailSession;

    public void send(String to, String subject, String body) throws AddressException, MessagingException {

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));
        InternetAddress[] addresses = {new InternetAddress(to)};
        message.setRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(subject);
        message.setText(body);
        Transport.send(message);

    }
}
