package com.nhnacademy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "jspFilter", urlPatterns = "*.jsp", initParams = {
    @WebInitParam(name = "whiteList", value = "/index.jsp")
})
public class jspFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //TODO jsp 직접 접근 차단

        filterChain.doFilter(servletRequest,servletResponse);
    }
}