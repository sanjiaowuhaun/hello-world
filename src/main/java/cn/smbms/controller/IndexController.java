package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index.html")
    public String toIndex(){
        return "index";
    }


    @RequestMapping("/test4")
    public String test3()throws Exception {
        Class.forName("com.abc.demo.Hello");
        return "index";
    }



}
