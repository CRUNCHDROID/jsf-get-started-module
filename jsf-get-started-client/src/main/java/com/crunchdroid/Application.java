package com.crunchdroid;

import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IServiceRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Riad YOUSFI
 */
public class Application {

    private static final String remoteServiceName = "java:global/jsf-get-started-ear/get-started-ejb-business-1.0-SNAPSHOT/IServiceImp!com.crunchdroid.services.IServiceRemote";

    public static void main(String[] args) throws NamingException {

        InitialContext context = new InitialContext();
        IServiceRemote service = (IServiceRemote) context.lookup(remoteServiceName);
        Person p = new Person();
        p.setFirstname("Adel");
        p.setLastname("YOUSFI");
        p.setAge(30);
        service.save(p);
        System.out.println(p);
    }

}
