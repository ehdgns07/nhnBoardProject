package com.nhnacademy.command.sessionmagagement;

import static com.nhnacademy.domain.BoardUser.Level.ADMIN;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UsersData;
import com.nhnacademy.repository.UserRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        UserRepository users = (UsersData) req.getServletContext().getAttribute("userDB");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        String userId;
        String userPwd;
        String userLevel;
        User user = (User) users.getUsers().get(id);

        if (Objects.nonNull(user)) {
            userId = user.getId();
            userPwd = user.getPassword();
            userLevel = String.valueOf(user.getLevel());
        } else {
            return "/loginForm.jsp";
        }

        if (id != null && pwd != null && id.equals(userId) && pwd.equals(userPwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            session.setAttribute("level",userLevel);

            if (users.getUser(userId).getLevel() == ADMIN) {
                return "/adminPage.jsp";
            }
            return "/index.jsp";
        }
        return "/loginForm.jsp";
    }

}

