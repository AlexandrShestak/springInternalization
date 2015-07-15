package com.shestakam.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alexandr on 15.7.15.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/hello")
    @ResponseBody
    public String translate(){

        return "index";
    }

}
