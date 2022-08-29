package com.nhnacademy.util;

import com.nhnacademy.domain.User;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ProfileUtils {
    private static final String UPLOAD_DIR = "profile";

    private ProfileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void upload(HttpServletRequest request, HttpServletResponse response,
                              User user) throws ServletException, IOException {
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + UPLOAD_DIR;

        // 프로필 처리부분
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fileName = null;
        String extension = null;

        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if(!fileName.isEmpty()) {
                extension = fileName.split("\\.")[1];
                part.write(uploadFilePath + File.separator + user.getId() + "." + extension);
            }
        }
        user.setProfileFileName(user.getId() + "." + extension);
    }

    private static String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
