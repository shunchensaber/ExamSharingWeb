package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by hades on 2018/12/24.
 *
 * 资讯控制类
 */
@Controller

public class NewsController {

    @RequestMapping("/news")
    public String news(Map<String, Object> model){

        return "news";
    }

    @RequestMapping("/news-cet")
    public String news_cet(Map<String, Object> model){

        return "news-cet";
    }

    @RequestMapping("/news-exam")
    public String news_exam(Map<String, Object> model){

        return "news-exam";
    }
}
