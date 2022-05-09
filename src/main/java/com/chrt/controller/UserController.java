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

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 回到首页
    @RequestMapping("/index")
    public String goToIndex() {
        return "index";
    }

    // 前往注册页面
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    // 注册
    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "redirect:/index";
    }

    // 用户名验证
    @PostMapping("/checkUsername")
    @ResponseBody
    public Boolean checkUsername(String username) {
        return userService.findByUn(username) == null;
    }

    // 前往登录页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    // 登录验证
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

    // 前往主页
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
