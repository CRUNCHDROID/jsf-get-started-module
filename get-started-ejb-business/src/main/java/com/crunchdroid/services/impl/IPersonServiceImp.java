package com.crunchdroid.services.impl;

import com.crunchdroid.dao.IDaoPersonLocal;
import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IPersonServiceLocal;
import com.crunchdroid.services.IPersonServiceRemote;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author Riad YOUSFI
 */
@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class IPersonServiceImp implements IPersonServiceLocal, IPersonServiceRemote, Serializable {

    @Resource(mappedName = "jms/TestConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/test/topic")
    private Topic topic;

    @EJB
    private IDaoPersonLocal dao;

    @Override
    public void save(Person person) {
        dao.save(person);
        try {
            publishMessage(person);
            Logger.getLogger(IPersonServiceImp.class.getName()).log(Level.SEVERE, "publishMessage ::: {0}", person);
        } catch (JMSException ex) {
            Logger.getLogger(IPersonServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Person person) {
        dao.update(person);
    }

    @Override
    public Person findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Person person) {
        dao.delete(person);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Person> findRange(int startPosition, int maxResult) {
        return dao.findRange(startPosition, maxResult);
    }

    @Override
    public int count() {
        return dao.count();
    }

    private void publishMessage(Person person) throws JMSException {

        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        MessageProducer messageProducer = session.createProducer(topic);

        ObjectMessage message = session.createObjectMessage();

        message.setObject(person);

        messageProducer.send(message);

        session.close();
        connection.close();

    }

}
