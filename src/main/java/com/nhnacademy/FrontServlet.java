package com.nhnacademy;

import com.nhnacademy.command.AddingAdminController;
import com.nhnacademy.command.GoToRegisterController;
import com.nhnacademy.command.board.ContentViewController;
import com.nhnacademy.command.FindUserForAdminController;
import com.nhnacademy.command.Command;
import com.nhnacademy.command.GetPostJspController;
import com.nhnacademy.command.board.ProfileImageUploadController;
import com.nhnacademy.command.sessionmagagement.LoginFormController;
import com.nhnacademy.command.sessionmagagement.LoginProcessController;
import com.nhnacademy.command.board.PostModifyController;
import com.nhnacademy.command.board.PostRefactorController;
import com.nhnacademy.command.board.PostingController;
import com.nhnacademy.command.sessionmagagement.LogoutController;
import com.nhnacademy.command.user.UserModifyController;
import com.nhnacademy.command.user.UserRegisterController;
import com.nhnacademy.command.user.userInfomationController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@MultipartConfig(fileSizeThreshold=2048*2048*10,
    maxFileSize=2048*2048*50,
    maxRequestSize=2048*2048*100)
@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREfIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.excute(req, resp);

            if (view.startsWith(REDIRECT_PREfIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREfIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);

            req.setAttribute("exception", ex);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;
        if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginFormController();
        }
        else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessController();
        }
        else if ("/search.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new FindUserForAdminController();
        }
        else if ("/add.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new AddingAdminController();
        }
        else if ("/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserModifyController();
        }
        else if ("/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserRegisterController();
        }
        else if ("/post.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostingController();
        }
        else if ("/post.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new GetPostJspController();
        }else if ("/contentView.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ContentViewController();
        }else if("/postUpdate.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostModifyController();
        }else if("/postRefactor.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new PostRefactorController();
        }else if("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutController();
        }else if("/userInfo.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new userInfomationController();
        }else if("/profileUpload.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new ProfileImageUploadController();
        }else if("/goToRegister.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new GoToRegisterController();
        }

        return command;
    }
}
