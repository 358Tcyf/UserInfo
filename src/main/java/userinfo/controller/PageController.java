package userinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Simple
 * @date on 2018/11/18 17:54
 */
@Controller
public class PageController {
    /**
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    /**
     * 打开登录页
     */
    @RequestMapping("/login")
    public String showLogin() {
        return "loginPage";
    }

    /**
     * 打开注册页
     */
    @RequestMapping("/signUp")
    public String showSignUp() {
        return "signUpPage";
    }

    /**
     * 打开用户信息管理页
     */
    @RequestMapping("/manage")
    public String showManage() {
        return "managePage";
    }
}
