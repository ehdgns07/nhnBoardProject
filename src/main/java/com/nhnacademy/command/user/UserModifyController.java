package com.nhnacademy.command.user;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserModifyController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if(Objects.equals(session,null)){
            //TODO error처리
        }
        User user = (User)session.getAttribute("user");
        UserRepository users = (UserRepository) req.getServletContext().getAttribute("userDB");
        String result = req.getParameter("button");

        if(Objects.equals(result,"edit" )){
            String[] editUser = req.getParameterValues("edituser");

            if(!Objects.equals(editUser[0], "")){
                user.setName(editUser[0]);
            }
            if(!Objects.equals(editUser[1], "")){
                user.setPassword(editUser[1]);
            }
            String userId = user.getId();
            users.modify(user);         //수정
            req.setAttribute("createUserId", userId);
            return "/profileUpload.jsp";
        }
            users.remove(user.getId()); //삭제
        return "/adminPage.jsp";

    }
}
