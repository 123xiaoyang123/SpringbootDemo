package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import com.sun.javafx.image.impl.IntArgb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * 注册页面跳转
     * */
    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }

    /*
     * 用户注册.
     * */
    @RequestMapping("register")
    public String register(User user,Model model) throws Exception {
        if (userService.login(user.getuName(),user.getuPwd()) == null) {
            userService.addUser(user);
            model.addAttribute("text", "注册成功!请登录!");
            model.addAttribute("name",user.getuName());
            model.addAttribute("pwd",user.getuPwd());
            model.addAttribute("type",user.getuType());
        } else {
            model.addAttribute("text", "该用户已存在!");
            return "register";
        }
        return "userLogin";
    }

    /*
     * 用户登入页面跳转
     * */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "userLogin";
    }

    /*
     * 用户登入
     * */
    @RequestMapping("login")
    public String login(String uName, String uPwd, Model model) throws Exception {
        User user=userService.login(uName, uPwd);
        if (user== null) {
            return "register";
        }
        model.addAttribute("userList", userService.selectUser());
        model.addAttribute("type", user.getuType());
        return "userList";
    }

    /*
     * 查询所有用户
     * */
    @RequestMapping("list")
    public String select(Model model) throws Exception {
        model.addAttribute("userList", userService.selectUser());
        return "userList";
    }

    /*
     * 删除用户
     * */
    @RequestMapping("delete")
    public String delete(int[] list, Model model) throws Exception {
        for (int i = 0; i < list.length; i++) {
            int uCode= list[i];
            userService.delete(uCode);
        }
        model.addAttribute("userList", userService.selectUser());
        return "userList";
    }

    /*
    * 修改页面跳转
    * */
    @RequestMapping("toUpdate")
    public String select(int uCode,Model model) throws Exception{
        model.addAttribute("user",userService.select(uCode));
        return "update";
    }


    /*
    * 修改用户信息
    * */
    @RequestMapping("update")
    public String update(User user,Model model)throws Exception{
        userService.update(user);
        model.addAttribute("userList", userService.selectUser());
        return "userList";
    }

}
