package com.nhnacademy.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToRegisterController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        return "register.jsp";
    }
}
