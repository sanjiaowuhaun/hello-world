package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderInfoController {

    //示例1
    @RequestMapping("orderinfo")
    public ModelAndView OrderInfo1() {
        return new ModelAndView("order/info", "message", "OrderInfo");
    }

    //示例2 ：处理多个url映射
    @RequestMapping({"info", "index"})  //或者@RequestMapping(value={"info","index"})
    public ModelAndView OrderInfo2() {
        return new ModelAndView("order/info", "message", "OrderInfo2");
    }

    //示例3
    @RequestMapping
    public ModelAndView OrderInfo3() {
        return new ModelAndView("order/info", "message", "OrderInfo3");
    }

    // 示例10  带占位符的URL
    @RequestMapping(value = "user/{userId}/order/{orderNumber}", method = RequestMethod.GET)
    public ModelAndView OrderInfo4(@PathVariable int userId, @PathVariable String orderNumber) {
        return new ModelAndView("order/info", "message", "userid:" + userId + " orderNumber:" + orderNumber);
    }
}