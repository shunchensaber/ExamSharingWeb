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



    @Autowired
    NewsRepository newsRepository;

    @RequestMapping("/news")
    public String news(Map<String, Object> model){

        return "news";
    }

    @RequestMapping("/news-cet")
    public String news_cet(ModelMap model){
        model.put("newslist", new LazyContextVariable<List<EduNews>>() {

            @Override
            protected List<EduNews> loadValue() {
                return newsRepository.findAll(new Sort(Sort.Direction.DESC, "date"));
            }
        });

        return "news-cet";
    }

    @RequestMapping("/news-exam")
    public String news_exam(Map<String, Object> model){

        return "news-exam";
    }
}
