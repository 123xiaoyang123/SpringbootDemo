package com.example.controller;

import com.example.pojo.jwt.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Controller
public class UserJwtTestController {

    private final JwtTokenUtils jwtTokenUtils;

    public UserJwtTestController(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @RequestMapping("toJwtLogin")
    public String toLogin(){
        return "jwtLogin";
    }

    @RequestMapping("jwtLogin")
    public String loginJet(String name,String pwd){
        Map map = new HashMap();
        map.put("name",name);
        map.put("pwd",pwd);
        jwtTokenUtils.createToken(map);
        return "index";
    }
}
