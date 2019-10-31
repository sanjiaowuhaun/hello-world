package cn.smbms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user2")
public class TestReceiveParamController2 {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // http://localhost:8080/user2/list?p=1&s=10
    // http://localhost:8080/user2/list?s=10
    @RequestMapping("/list")
    public String test1(@RequestParam("p") Integer pageIndex,
                        @RequestParam(value = "s",required = false) Integer size){
        System.out.println("pageIndex==>" + pageIndex);
        System.out.println("size==>" + size);
        return "index";
    }

    // http://localhost:8080/user2/list1?p=2&s=5
    // http://localhost:8080/user2/list1
    @RequestMapping("/list1")
    public String test2(@RequestParam(value="p",defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "s",defaultValue = "10") Integer size){
        System.out.println("pageIndex==>" + pageIndex);
        System.out.println("size==>" + size);
        return "index";
    }

    // http://localhost:8080/user2/register?userName=admin&password=123&email=xxx@xx.com
    @RequestMapping("/register")
    public String doRegister(User user){
        System.out.println("user==>" + user);
        return "index";
    }


    // http://localhost:8080/user2/delete?id=1&id=2&id=3
    @RequestMapping("/delete")
    public String doDelete(Integer[] id){
        System.out.println("id==>" + Arrays.toString(id));
        return "index";
    }
    // http://localhost:8080/user2/delete1?id=1&id=2&id=3
    @RequestMapping("/delete1")
    public String doDelete(@RequestParam("id") List<Integer> id){
        System.out.println("id==>" + id);
        return "index";
    }
    // http://localhost:8080/user2/WEB-INF/say?id=1&id=2&id=3
    @RequestMapping(value = "/WEB-INF/say",method = {RequestMethod.GET})
    public String sayHello() {
        logger.info("hello springmvc,methed=get");
        return "index";
    }
    // http://localhost:8080/user2/email?send=5
    @RequestMapping(value = "/email",method = {RequestMethod.GET},params = "send")
    public String email(String send) {
        logger.info("params: " + send);
        return "index";
    }
    // http://localhost:8080/user2/email?id=1&id=2&id=3&save=5
    @RequestMapping(value = "/email",method = {RequestMethod.GET},params = "save")
    public String email1(String save) {
        logger.info("params: " + save);
        return "index";
    }
        // 示例11  带占位符的URL
        @RequestMapping(value = "order*", method = RequestMethod.GET)
        //@RequestMapping(value = "order?", method = RequestMethod.GET)
        //@RequestMapping(value = "order/**", method = RequestMethod.GET)
        public ModelAndView OrderInfo5(String orderNumber) {
            return new ModelAndView("order/info", "message", "OrderInfo5");
        }
}
