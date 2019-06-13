package com.course.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class VerifyCookie {
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    &&cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;
    }
}
