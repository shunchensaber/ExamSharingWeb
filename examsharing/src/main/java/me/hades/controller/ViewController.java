package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hades on 2018/12/23.
 * <p>
 * 基本视图控制类
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(ModelMap model, HttpSession session) {
        model.put("login_tag", false);
        if (session.getAttribute("username") != null) {
//            Logger.getGlobal().info(session.getAttribute("username").toString());
            model.put("username", session.getAttribute("username"));
            session.removeAttribute("username");
            model.put("login_tag", true);
        }
        return "index";
    }

    @RequestMapping("team")
    public String team(Map<String, Object> model) {

        return "team";
    }

}
