package com.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeMakerTest {

    @RequestMapping("hello")
    public String sayHello(Model model){
        model.addAttribute("name","koshimizu");
        return "hello";
    }

    @RequestMapping("hi")
    public String sayHi(Model model){
        model.addAttribute("name","koshimizu");
        return "hi";
    }
}
