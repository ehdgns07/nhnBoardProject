package com.nhnacademy.command.board;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentViewController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String postSeq = req.getQueryString().split("=")[1];
        PostRepository board = (PostRepository) req.getServletContext().getAttribute("Board");
        Post post = (Post) board.getPosts().get(Long.parseLong(postSeq));

        req.setAttribute("post", post);
        return "/contentView.jsp";
    }
}
