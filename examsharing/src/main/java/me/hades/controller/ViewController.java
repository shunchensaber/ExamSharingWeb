package me.hades.controller;


import com.sun.org.apache.regexp.internal.RE;
import me.hades.entiy.LoginTable;
import me.hades.repository.LoginTableRepository;
import me.hades.repository.UserRepository;
import me.hades.utils.CookieUtils;
import me.hades.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


/**
 * Created by hades on 2018/12/23.
 * <p>
 * 基本视图控制类
 */
@Controller
public class ViewController {

    @Autowired
    LoginTableRepository loginTableRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index(ModelMap model, HttpSession session) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");

        if (session.getAttribute("username") != null) {
//            Logger.getGlobal().info(session.getAttribute("username").toString());
            String username = (String) session.getAttribute("username");
            model.put("username", username);
            session.removeAttribute("username");

            LoginTable loginTable = new LoginTable();
            loginCookie = checkLoginTableByUsername(username);
            if (loginCookie != null) {
                // 刷新Cookie
                loginCookie = MD5Util.encoder(username+ new Date().toString());
                loginTable.setCookie(loginCookie);
                loginTable.setUsername(username);
                loginTableRepository.updateCookieByUsername(loginCookie, username);

            }else {
                loginCookie = MD5Util.encoder(username+ new Date().toString());
                loginTable.setCookie(loginCookie);
                loginTable.setUsername(username);
                loginTableRepository.save(loginTable);

            }
            CookieUtils.writeCookie(requestAttributes.getResponse(), "login", loginCookie);
            model.put("login_tag", true);
        } else if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }
        return "index";
    }

    @RequestMapping("team")
    public String team(Map<String, Object> model) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");

        if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }
        return "team";
    }


    /**
     * 判断登录表里是否存在对应的用户
     * @param username
     * @return
     */
    public String checkLoginTableByUsername(String username) {
        LoginTable loginTable = loginTableRepository.findLoginTableByUsername(username);
        if (loginTable == null) {
            return null;
        }
        else {
            return loginTable.getCookie();
        }
    }

}
