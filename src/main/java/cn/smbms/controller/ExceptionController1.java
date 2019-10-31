package cn.smbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExceptionController1 {

    @RequestMapping("/test1")
    public String test1(){
        String str = null;
        System.out.println(str.length());
        return "index";
    }

    @RequestMapping("/test2")
    public String test2(){
        System.out.println(1 / 0);
        return "index";
    }

    @RequestMapping("/test3")
    public String test3()throws Exception {
       Class.forName("com.abc.demo.Hello");
        return "index";
    }


    // 局部异常处理： 只能处理当前控制器方法中的异常
    // 加  @ExceptionHandler 的方法就是用于当前控制器的方法中出错时要执行的错误处理
    //  @ExceptionHandler(NullPointerException.class) 处理空指针异常
    //  @ExceptionHandler(Exception.class) 处理异常
    @ExceptionHandler(NullPointerException.class)
    // 写一个处理异常的方法
    public ModelAndView handlerException1(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg","空指针异常");
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(ArithmeticException.class)
    // 写一个处理异常的方法
    public ModelAndView handlerException2(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler
    // 写一个处理异常的方法
    public ModelAndView handlerException3(HttpServletRequest request,
                                          HttpServletResponse response,
                                          Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg","服务器异常，请稍后再试");
        mv.setViewName("error");
        return mv;
    }

}
