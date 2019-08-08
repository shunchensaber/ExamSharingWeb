package me.hades.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
    @RequestMapping("download")
    public String download()
    {
        return "download";
    }

    @RequestMapping("index1")
    public String index1()
    {
        return "index_ele";
    }
    @RequestMapping("index2")
    public String index2()
    {
        return "index_ele1";
    }
    @RequestMapping("ji")
    public String ji()
    {
        return "ji";
    }
}
