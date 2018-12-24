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
    public String login(Map<String, Object> model){

        return "login";
    }

    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                             HttpSession session){

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "redirect:/";
    }


    @RequestMapping("/register")
    public String register(Map<String, Object> model){

        return "register";
    }


}
