package me.hades.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hades on 2018/12/26.
 */
public class CookieUtils {

    public static String getCookie(HttpServletRequest request, String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void writeCookie(HttpServletResponse response, String cookieName, String value){
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        //保存7天
        cookie.setMaxAge(7 * 24 * 60 * 60);
        System.out.println(cookie.getName() + ": " + cookie.getValue());
        response.addCookie(cookie);
    }

}
