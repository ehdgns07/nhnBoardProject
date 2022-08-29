package com.nhnacademy.filter;

import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "userProfileViewCountFilter", urlPatterns = "/userInfo.do")
public class UserProfileViewCountFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String userId = req.getQueryString().split("=")[1];
        UserRepository userDB = (UserRepository) req.getServletContext().getAttribute("userDB");

        User user = userDB.getUser(userId);
        user.increaseViewCount();

        chain.doFilter(request, response);
    }
}
