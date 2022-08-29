package com.nhnacademy.filter;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.PostRepository;
import com.nhnacademy.repository.UserRepository;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "postViewCountFilter", urlPatterns = "/contentView.do")
public class PostViewCounter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String postSeq = req.getQueryString().split("=")[1];
        PostRepository board = (PostRepository) req.getServletContext().getAttribute("Board");
        Post post = (Post) board.getPosts().get(Long.parseLong(postSeq));
        post.increaseViewCount();

        chain.doFilter(request, response);
    }
}
