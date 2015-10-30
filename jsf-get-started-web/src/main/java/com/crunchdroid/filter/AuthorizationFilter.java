package com.crunchdroid.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi420
 */
@WebFilter(filterName = "authFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            HttpSession session = httpServletRequest.getSession(false);

            String uri = httpServletRequest.getRequestURI();
            System.out.println("URI ::: " + uri);
            
            if (uri.contains("/Login.xhtml")
                    || session != null && session.getAttribute("user") != null
                    || uri.contains("/public/")
                    || uri.contains("javax.faces.resource")
                    ) {
                chain.doFilter(request, response);
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/faces/Login.xhtml");
            }

        } catch (IOException | ServletException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy() {

    }

}
