package com.nhnacademy.command.user;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userInfomationController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getQueryString().split("=")[1];
        UserRepository userDB = (UserRepository) req.getServletContext().getAttribute("userDB");
        User user = userDB.getUser(userId);

        req.setAttribute("infoUser", user);

        return "/userInfoView.jsp";
    }
}
