package me.hades.controller;

import me.hades.entiy.EduNews;
import me.hades.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.LazyContextVariable;

import java.util.List;
import java.util.Map;

/**
 * Created by hades on 2018/12/24.
 *
 * 资讯控制类
 */
@Controller
public class NewsController {

    private static int PAGE_SIZE = 10;

    @Autowired
    NewsRepository newsRepository;

    @RequestMapping("/news/{id}")
    public String news(@PathVariable("id") Integer id,
            ModelMap model){
        model.put("news", newsRepository.findEduNewsById(id) );
        return "news";
    }

    @RequestMapping("/news/list")
    public String newsList(@RequestParam("page") Integer page, ModelMap model){

        Pageable pageable = new PageRequest(page, PAGE_SIZE, Sort.Direction.DESC, "date");
//        System.out.println(newsRepository.findAll(pageable).getContent());
        model.put("newslist", newsRepository.findAll(pageable).getContent());
        return "news-cet::newsfragment";
    }

    @RequestMapping("/news-cet")
    public String news_cet(ModelMap model){
        Pageable pageable = new PageRequest(0, PAGE_SIZE, Sort.Direction.DESC, "date");
//        System.out.println(newsRepository.findAll(pageable).getContent());
        model.put("page_count", (newsRepository.findAll().size() / PAGE_SIZE) );
        model.put("newslist", newsRepository.findAll(pageable).getContent());
        return "news-cet";
    }

    @RequestMapping("/news-exam")
    public String news_exam(Map<String, Object> model){

        return "news-exam";
    }
}
