package com.nhnacademy.command.board;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostingContents;
import com.nhnacademy.repository.PostRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostingController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("postTitle");
        String content = req.getParameter("postContent");
        HttpSession session = req.getSession(false);
        if(Objects.equals(session,null)){
            //TODO error처리
        }
        String userId = (String) session.getAttribute("id");

        Post post = new PostingContents(title, content, userId, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm")));
        PostRepository board = (PostRepository) req.getServletContext().getAttribute("Board");

        board.register(post);
        return "/index.jsp";
    }
}
