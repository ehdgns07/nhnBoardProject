package com.nhnacademy.command.board;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostModifyController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String modifyTitle = req.getParameter("postTitle");
        String modifyContent = req.getParameter("postContent");

        String postId = req.getQueryString().split("=")[1];
        PostRepository board = (PostRepository) req.getServletContext().getAttribute("Board");
        Post post = board.getPost(Long.parseLong(postId));

        post.setTitle(modifyTitle);
        post.setContent(modifyContent);

        req.setAttribute("post", post);
        return "/contentView.jsp";
    }
}
