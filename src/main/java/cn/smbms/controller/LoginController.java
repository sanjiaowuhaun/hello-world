package cn.smbms.controller;

import cn.smbms.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @RequestMapping("/login.html")
    public ModelAndView toLogin(Model model) {
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public String doLogin(String userName, String password, Model model, HttpSession session) {
        logger.info("用户名： " + userName + " , 密码： " + password);
//        System.out.println("用户名： " + userName + " , 密码： " + password);
        ModelAndView modelAndView = new ModelAndView();
        if ("admin".equals(userName) && "123".equals(password)) {
            session.setAttribute(Constants.LOGIN_USER,userName);
            return "redirect:/index.html";
        }
        model.addAttribute("error","用户名或密码错误");
        return "login";
    }
}
