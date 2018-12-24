package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.runtime.Log;

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
        if (session.getAttribute("username") != null) {
            Logger.getGlobal().info(session.getAttribute("username").toString());
            model.put("username", session.getAttribute("username"));
            session.removeAttribute("username");
        }
        return "index";
    }

    @RequestMapping("team")
    public String team(Map<String, Object> model) {

        return "team";
    }

}
