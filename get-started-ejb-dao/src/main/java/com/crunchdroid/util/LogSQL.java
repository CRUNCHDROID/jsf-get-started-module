/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchdroid.util;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.eclipse.persistence.internal.jpa.EJBQueryImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.DatabaseQuery;
import org.eclipse.persistence.sessions.DatabaseRecord;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Riad YOUSFI
 */
public class LogSQL {

    public static void getSqlString(EntityManager em, Query q) {
        Session session = em.unwrap(JpaEntityManager.class).getActiveSession();
        DatabaseQuery databaseQuery = ((EJBQueryImpl) q).getDatabaseQuery();
        databaseQuery.prepareCall(session, new DatabaseRecord());
        String sql = databaseQuery.getSQLString();
        System.out.println("Query ::: " + sql);
    }

}
