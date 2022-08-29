package com.nhnacademy.command.sessionmagagement;

import com.nhnacademy.command.Command;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);

        if(Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))){
            return "/loginForm.jsp";
        }
        return "/index.jsp";


    }
}
