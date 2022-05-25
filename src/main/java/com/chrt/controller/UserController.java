package com.chrt.controller;

import com.chrt.pojo.User;
import com.chrt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 用于控制user在页面中的操作流程
 * @author chrt
 * @version 1.0.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 回到首页
     * @return "resources/templates/index.html"
     */
    @RequestMapping("/index")
    public String goToIndex() {
        return "index";
    }

    /**
     * 前往注册页面
     * @return "resources/templates/register.html"
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 用户提交表单后的信息加载在user中，并将user添加进数据库中
     * 添加成功后返回首页
     * @param user 用户信息
     * @return "resources/templates/index.html"
     */
    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "redirect:/index";
    }

    /**
     * 检查用户名是否存在
     * 用户名存在则返回false，不存在返回true
     * @param username 用户名
     * @return 数据库中是否不存在此用户名
     */
    @PostMapping("/checkUsername")
    @ResponseBody
    public Boolean checkUsername(String username) {
        return userService.findByUn(username) == null;
    }

    /**
     * 前往登录页面
     * @return "resources/templates/login.html"
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 进行用户登录验证，通过则前往主页面
     * 否则回到登录页面
     * @param user 用户信息
     * @param model 用于存放错误信息
     * @param redirectAttributes 用于存放用户信息
     * @return 主页或登录页
     */
    @PostMapping("/login")
    public String login(User user, Model model, RedirectAttributes redirectAttributes) {
        if (userService.findByUnAndPwd(user) != null) {
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            redirectAttributes.addFlashAttribute("password", user.getPassword());
            return "redirect:/main";
        }
        model.addAttribute("errMsg", "用户名或密码有误");
        return "forward:/toLogin";
    }

    /**
     * 前往主页
     * 如果没有携带用户信息，则退回首页
     * @param modelMap 存放着用户信息
     * @param model 用于存放用户信息
     * @return 主页或首页
     */
    @RequestMapping("/main")
    public String toMain(ModelMap modelMap, Model model) {
        String username = (String) modelMap.get("username");
        String password = (String) modelMap.get("password");
        if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "main";
        }
        return "redirect:/index";
    }
}
