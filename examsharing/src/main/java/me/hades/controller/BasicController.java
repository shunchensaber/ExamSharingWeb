package me.hades.controller;

import me.hades.entiy.UserInfo;
import me.hades.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BasicController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Controller
    public class HomeController {
        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String login() {
            return "login";
        }


        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String login(HttpServletRequest request, UserInfo user, Model model) {
            System.out.println(user.toString());
            HttpSession session = request.getSession();
            System.out.println(user.getUsername()+user.getPassword());
            UserInfo userInfo = userInfoRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (userInfo != null) {
                session.setAttribute("uname", userInfo.getName());
                session.setAttribute("uid", userInfo.getUid());
                session.setAttribute("userinfo",userInfo);
                return "redirect:/page";
            } else {
                model.addAttribute("msg", "登录失败");
                return "login";
            }
        }
        
    }
}
