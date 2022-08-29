package com.nhnacademy.command;

import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindUserForAdminController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        String findUserId = req.getParameter("userid");
        UserRepository UserData = (UserRepository) req.getServletContext().getAttribute("userDB");
        User user = UserData.getUser(findUserId);
        HttpSession session = req.getSession(false);

        if (Objects.isNull(user)) {
            error(req, resp);
        }

        session.setAttribute("user", user);

        return "/searchResult.jsp";
    }

    private void error(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("exception", "사용자 id 없음");
        RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
