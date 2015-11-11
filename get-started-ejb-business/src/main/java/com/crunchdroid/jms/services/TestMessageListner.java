package com.crunchdroid.jms.services;

import com.crunchdroid.entities.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@MessageDriven(mappedName = "jms/test/topic")
public class TestMessageListner implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                ObjectMessage msg = (ObjectMessage) message;
                Person p = (Person) msg.getObject();
                Logger.getLogger(TestMessageListner.class.getName()).log(Level.INFO, "onMessageListner ::: {0}", p);
            } catch (JMSException ex) {
                Logger.getLogger(TestMessageListner.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
