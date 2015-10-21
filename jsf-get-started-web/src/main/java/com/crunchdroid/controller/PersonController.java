package com.crunchdroid.controller;

import com.crunchdroid.entities.Person;
import com.crunchdroid.services.IServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riad YOUSFI
 */
@WebServlet(name = "PersonController", urlPatterns = {"/Person"})
public class PersonController extends HttpServlet {

    @EJB
    private IServiceLocal service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        p.setLastname("YOUSFI");
        p.setFirstname("Soumaya");
        p.setAge(29);
        service.save(p);
        request.setAttribute("person", p);
//        request.setAttribute("person", "Riad");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
