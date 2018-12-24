package me.hades.controller;

import me.hades.entiy.User;
import me.hades.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;

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
        if (checkUserExist(username)) {
            User user = userRepository.findUserByUsername(username);
            if (user.getPassword().equals(password)) {
                return "redirect:/";
            }
        }
        // 只要不是正确登录，就都是失败
        session.setAttribute("login_tag", false);
        return "redirect:/login";


    }


    @RequestMapping("/register")
    public String register(Map<String, Object> model){

        return "register";
    }


    /**
     * 根据用户名检查用户是否存在
     * @param username 用户名
     * @return true 代表存在 false 代表不存在
     */
    private boolean checkUserExist(String username) {
        if (null == userRepository.findUserByUsername(username)) {
            return false;
        } else {
            return true;
        }
    }
}
