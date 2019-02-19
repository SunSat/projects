package com.sunsat.sathish.j2ee.health.login.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.*;
import java.io.IOException;

public class CustomCsrfFilter implements Filter {

    private CsrfFilter csrfFilter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        CsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        csrfFilter = new CsrfFilter(repository);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        csrfFilter.doFilter(request,response,chain);
        /*chain.doFilter(request,response);*/
    }

    public CsrfFilter getCsrfFilter() {
        return csrfFilter;
    }

    public void setCsrfFilter(CsrfFilter csrfFilter) {
        this.csrfFilter = csrfFilter;
    }
}
