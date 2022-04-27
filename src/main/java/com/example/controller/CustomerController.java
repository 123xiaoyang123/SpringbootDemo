package com.example.controller;

import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*
     * 查询用户
     * */
    @RequestMapping("sel")
    public String selectAll(Model model) throws Exception {
        model.addAttribute("userList", customerService.selectAll());
        return "customerList";
    }
}
