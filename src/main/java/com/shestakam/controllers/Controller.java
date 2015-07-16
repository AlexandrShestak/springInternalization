package com.shestakam.controllers;

import com.shestakam.dao.UserDao;
import com.shestakam.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private  UserDao userDao;

    @RequestMapping("/start")
    public String start(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();


        for(Cookie cookie : cookies){
            if("remember".equals(cookie.getName())){
                if (cookie.getValue().equals("on"))
                    return "welcome";
            }
        }
        return "index";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        return "index";
    }


    @RequestMapping("/hello")
    public String translate(@RequestParam String  login,@RequestParam String password,
                            @RequestParam String language , @RequestParam String remember,
                            HttpServletRequest request,HttpServletResponse response){


        Cookie languageCookie = new Cookie("myCookieLanguage", language);
        response.addCookie(languageCookie);
        Cookie loginCookie = new Cookie("login", login);
        response.addCookie(loginCookie);



        User user = userDao.get(login);
        if (user != null) {

            Cookie firstName = new Cookie("firstName",user.getFirstName());
            Cookie lastName = new Cookie("lastName",user.getLastName());
            Cookie lang = new Cookie("language",language);
            Cookie rem = new Cookie("remember",remember);
            response.addCookie(firstName);
            response.addCookie(lastName);
            response.addCookie(lang);
            response.addCookie(rem);
            return "welcome";
        }
        else{
            request.setAttribute("error","Incorrect Password");
            return "index";
        }
    }


}
