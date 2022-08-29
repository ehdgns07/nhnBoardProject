package com.nhnacademy.command;

import com.nhnacademy.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPostJspController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        return "post.jsp";
    }
}
