package com.nhnacademy.filter;

import com.nhnacademy.util.ErrorControll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "forbiddenUser", urlPatterns = "*",initParams = {
    @WebInitParam(name ="blackList", value="/update.do,/register.do,/search.do")
})
public class forbiddenUserAboutAdminPagefilter implements Filter {
    List<String> uri = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String[] url = filterConfig.getInitParameter("blackList").split(",");
        Arrays.stream(url).forEach(s->uri.add(s));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        if(uri.contains(req.getRequestURI())){
            if(Objects.equals(String.valueOf(session.getAttribute("level")), "USER")){
                ErrorControll.error((HttpServletRequest) request, (HttpServletResponse) response,"권한이 없습니다.");
            }
        }
        chain.doFilter(request, response);
    }
}
