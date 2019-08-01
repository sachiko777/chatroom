package com.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String requeseIndex(){
        return "index";
    }

//    @RequestMapping("/{page}")
//    public String requesePage(@PathVariable String page){
//        return page;
//    }

    @RequestMapping("/chat")
    public String toChat(){
        return "chat";
    }

    @RequestMapping("/pMsg")
    public String toPersonMsg(){
        return "pMsg";
    }

    @RequestMapping("/chat/tologin")
    public String toLoginPage(){
        return "/WEB-INF/login_chat.jsp";
    }


}
