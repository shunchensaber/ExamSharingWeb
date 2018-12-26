package me.hades.controller;

import me.hades.entiy.LoginTable;
import me.hades.repository.LoginTableRepository;
import me.hades.repository.UserRepository;
import me.hades.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

/**
 * Created by hades on 2018/12/24.
 */
@Controller
public class CourseController {
    
    @Autowired
    LoginTableRepository loginTableRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/course")
    public String course(Map<String, Object> model){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");
        if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }
        return "course";
    }


    @RequestMapping("/course-cet")
    public String course_cet(Map<String, Object> model){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");
        if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }
        return "course-cet";
    }

    @RequestMapping("/course-exam")
    public String course_exam(Map<String, Object> model){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");
        if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }
        return "course-exam";
    }
}
