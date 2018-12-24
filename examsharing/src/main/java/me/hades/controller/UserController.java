package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hades on 2018/12/24.
 */
@Controller
public class UserController {



    @RequestMapping("/login")
    public String login(Map<String, Object> model, HttpSession session){
        if (session.getAttribute("login_tag") != null) {
            model.put("login_tag", false);
            model.put("username", session.getAttribute("username"));
            session.removeAttribute("login_tag");
            session.removeAttribute("username");
        }
        return "login";
    }

    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                             HttpSession session){
        session.setAttribute("username", username);
        if (username.equals("123456") && password.equals("123456")) {
            return "redirect:/";
        } else {
            session.setAttribute("login_tag", false);
            return "redirect:/login";
        }

    }


    @RequestMapping("/register")
    public String register(Map<String, Object> model){

        return "register";
    }


}
