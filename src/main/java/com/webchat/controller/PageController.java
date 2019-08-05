package com.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String requeseIndex(){
        return "/index.jsp";
    }

//    @RequestMapping("/{page}")
//    public String requesePage(@PathVariable String page){
//        return page;
//    }

    @RequestMapping("/chat")
    public String toChat(String friendId, HttpServletRequest request ){
        request.getSession().setAttribute("FRIEND_ID", friendId);//用户id
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

    @RequestMapping("/")
    public String toLogin(){
        return "/login_chat";
    }


}
