package me.hades.controller;

import me.hades.entiy.EduNews;
import me.hades.entiy.LoginTable;
import me.hades.repository.LoginTableRepository;
import me.hades.repository.NewsRepository;
import me.hades.repository.UserRepository;
import me.hades.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.context.LazyContextVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hades on 2018/12/24.
 * <p>
 * 资讯控制类
 */
@Controller
public class NewsController {

    private static int PAGE_SIZE = 10;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    LoginTableRepository loginTableRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/news/{id}")
    public String news(@PathVariable("id") Integer id,
                       ModelMap model) {
        model.put("news",newsRepository.findEduNewsById(id));
        return "news";
    }

    @RequestMapping("/news/list")
    public String newsList(@RequestParam("page") Integer page, ModelMap model) {

        Pageable pageable = new PageRequest(page, PAGE_SIZE, Sort.Direction.DESC, "date");
//        System.out.println(newsRepository.findAll(pageable).getContent());
        model.put("newslist", newsRepository.findAll(pageable).getContent());
        return "news-cet::newsfragment";
    }

    @RequestMapping("/news-cet")
    public String news_cet(ModelMap model) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginCookie = CookieUtils.getCookie(requestAttributes.getRequest(), "login");
        if (  loginCookie == null || loginCookie.equals("") ) {
            model.put("login_tag", false);
        }else {
            LoginTable loginTable = loginTableRepository.findLoginTableByCookie(loginCookie);
            model.put("username", userRepository.findUserByUsername(loginTable.getUsername()).getNickname());
            model.put("login_tag", true);
        }

        Pageable pageable = new PageRequest(0, PAGE_SIZE, Sort.Direction.DESC, "date");
//        System.out.println(newsRepository.findAll(pageable).getContent());
        model.put("page_count", (newsRepository.findAll().size() / PAGE_SIZE));
        model.put("newslist", newsRepository.findAll(pageable).getContent());
        return "news-cet";
    }

    @RequestMapping("/news-exam")
    public String news_exam(Map<String, Object> model) {

        return "news-exam";
    }



}
