package com.chrt.controller;

import com.chrt.pojo.User;
import com.chrt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // 注册验证
    @PostMapping("/register")
    public String register(User user, Model model) {
        if (userService.findByUsername(user) != null) {
            model.addAttribute("errMsg", "用户名已存在");
            return "forward:/toRegister";
        } else if (user.getPassword().length() < 8) {
            model.addAttribute("errMsg", "密码不足8位");
            return "forward:/toRegister";
        }
        userService.addUser(user);
        return "redirect:/index";
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

    // 更改用户名
    @PostMapping("/updateUn")
    public String updateUn(String oldName, String newName, Model model) {
        if (oldName.equals(newName)) {
            model.addAttribute("errMsg", "新名字与原名字相同");
            return "";
        } else if (userService.findByUsername(newName) != null) {
            model.addAttribute("errMsg", "该名字已存在");
            return "";
        }
        userService.updateUsername(oldName, newName);
        return "";
    }

    // 更改密码
    @PostMapping("/updatePwd")
    public String updatePwd(User user, String newPwd, Model model) {
        if (user.getPassword().equals(newPwd)) {
            model.addAttribute("errMsg", "新密码与原密码相同");
            return "";
        } else if (newPwd.length() < 8) {
            model.addAttribute("errMsg", "新密码长度不足8位");
            return "";
        }
        userService.updatePassword(user.getUsername(), newPwd);
        return "";
    }
}
