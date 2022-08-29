package com.nhnacademy.initializer;

import static com.nhnacademy.domain.BoardUser.Level.ADMIN;
import static com.nhnacademy.domain.BoardUser.Level.USER;

import com.nhnacademy.domain.BoardUser;
import com.nhnacademy.domain.User;
import com.nhnacademy.repository.Board;
import com.nhnacademy.repository.UsersData;
import com.nhnacademy.repository.UserRepository;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.Servlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSession.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        servletContext.setAttribute("userDB", inituser());
        servletContext.setAttribute("Board", new Board());

    }

    private UserRepository inituser() {
        UserRepository users = new UsersData();

        User admin1 = new BoardUser("admin1", "1234", "관리자1", ADMIN);
        User admin2 = new BoardUser("admin2", "1234", "관리자2", ADMIN);
        User user1  = new BoardUser("user1", "1234", "이동훈", USER);

        users.add(admin1);
        users.add(admin2);
        users.add(user1);

        return users;
    }
}
