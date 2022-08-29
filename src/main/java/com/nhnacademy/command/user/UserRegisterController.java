package com.nhnacademy.command.user;

import static com.nhnacademy.domain.BoardUser.Level.USER;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.BoardUser;
import com.nhnacademy.repository.UsersData;
import com.nhnacademy.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("registerUserId");
        String userPwd = req.getParameter("registerUserpwd");
        String userName  = req.getParameter("registerUserName");

        UserRepository userDB = (UsersData) req.getServletContext().getAttribute("userDB");
        userDB.add(new BoardUser(userId,userPwd,userName,USER));

        req.setAttribute("createUserId", userId);
        return "/profileUpload.jsp";
    }
}
