package com.nhnacademy.command.board;

import static com.nhnacademy.domain.BoardUser.Level.ADMIN;

import com.nhnacademy.command.Command;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;
import com.nhnacademy.util.ProfileUtils;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfileImageUploadController implements Command {
    private static final String PROFILE_IMAGE_SAVE_DIRECTORY = "profile";

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String userId = req.getQueryString().split("=")[1];
        UserRepository userDB = (UserRepository) req.getServletContext().getAttribute("userDB");
        User user = userDB.getUser(userId);
        if(Objects.equals(user.getLevel(), ADMIN)){
            return "adminPage.jsp";
        }

        ProfileUtils.upload(req,resp,user);
        return "adminPage.jsp";
    }
}
