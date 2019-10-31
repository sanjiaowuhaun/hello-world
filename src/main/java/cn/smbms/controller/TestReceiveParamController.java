package cn.smbms.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestReceiveParamController {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // http://localhost:8080/user/list?p=1&s=10
    // http://localhost:8080/user/list?s=10
    @RequestMapping("/user/list")
    public String test1(@RequestParam("p") Integer pageIndex,
                        @RequestParam(value = "s",required = false) Integer size){
        logger.info("pageIndex==>" + pageIndex);
        logger.info("size==>" + size);
        return "index";
    }

    // http://localhost:8080/user/list1?p=2&s=5
    // http://localhost:8080/user/list1
    @RequestMapping("/user/list1")
    public String test2(@RequestParam(value="p",defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "s",defaultValue = "10") Integer size){
        logger.info("pageIndex==>" + pageIndex);
        logger.info("size==>" + size);
        return "index";
    }

    // http://localhost:8080/user/register?userName=admin&password=123&email=xxx@xx.com
    @RequestMapping("/user/register")
    public String doRegister(User user){
        logger.info("user==>" + user);
        return "index";
    }


    // http://localhost:8080/user/delete?id=1&id=2&id=3
    @RequestMapping("/user/delete")
    public String doDelete(Integer[] id){
        logger.info("id==>" + Arrays.toString(id));
        return "index";
    }
    // http://localhost:8080/user/delete1?id=1&id=2&id=3
    @RequestMapping("/user/delete1")
    public String doDelete(@RequestParam("id") List<Integer> id){
        logger.info("id==>" + id);
        return "index";
    }
}
