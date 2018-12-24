package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by hades on 2018/12/24.
 */
@Controller
public class CourseController {


    @RequestMapping("/course")
    public String course(Map<String, Object> model){

        return "course";
    }


    @RequestMapping("/course-cet")
    public String course_cet(Map<String, Object> model){

        return "course-cet";
    }

    @RequestMapping("/course-exam")
    public String course_exam(Map<String, Object> model){

        return "course-exam";
    }
}
