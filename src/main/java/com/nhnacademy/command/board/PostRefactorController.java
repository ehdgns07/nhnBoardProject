package com.nhnacademy.command.board;


import com.nhnacademy.command.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.util.ErrorControll;
import com.nhnacademy.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostRefactorController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String result = req.getParameter("button");

        String postSeq = req.getQueryString().split("=")[1];
        PostRepository board = (PostRepository) req.getServletContext().getAttribute("Board");
        Post post = (Post) board.getPosts().get(Long.parseLong(postSeq));
        HttpSession session = req.getSession(false);

        if (!session.getAttribute("id").equals(post.getWriterUserId())) {
            ErrorControll.error(req, resp, "작성자가 아닙니다.");
        }

        if (result.equals("edit")) {
            req.setAttribute("post", post);
            return "postUpdate.jsp";
        } else {
            // 삭제로직 구현
            board.remove(Long.parseLong(postSeq));
            return "/index.jsp";
        }
    }
}
