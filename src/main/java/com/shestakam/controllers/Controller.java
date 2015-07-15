package com.shestakam.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by alexandr on 15.7.15.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/hello")
    public String translate(@RequestParam String  login,@RequestParam String password,
                            @RequestParam String language , @RequestParam boolean remember,
                            HttpServletRequest request,HttpServletResponse response){

        Cookie cookie = new Cookie("myCookieLanguage","ru");
        response.addCookie(cookie);
        return "index";
    }

}
