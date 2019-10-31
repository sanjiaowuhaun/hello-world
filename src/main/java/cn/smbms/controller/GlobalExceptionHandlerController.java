package cn.smbms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 加 @ControllerAdvice 注解后，  @ExceptionHandler 就可以处理全局异常了
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler
    // 写一个处理异常的方法
    public ModelAndView handlerException3(HttpServletRequest request,
                                          HttpServletResponse response,
                                          Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg","全局异常： 服务器异常，请稍后再试");
        mv.setViewName("error");
        return mv;
    }
}
