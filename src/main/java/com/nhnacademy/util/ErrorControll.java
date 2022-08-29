package com.nhnacademy.util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorControll {
    private ErrorControll(){
        throw new IllegalStateException("Utility class");
    }
   public static void error(HttpServletRequest req, HttpServletResponse resp, String message) {
        req.setAttribute("exception", message);
        RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
