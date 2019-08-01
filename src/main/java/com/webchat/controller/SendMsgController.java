package com.webchat.controller;

import com.alibaba.fastjson.JSON;
import com.webchat.pojo.Messages;
import com.webchat.pojo.util.RespDataObj;
import com.webchat.webSocket.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Description: 发送消息
 * @author: che
 * @Date: 2016年1月1日 下午7:32:15
 */
@Controller
public class SendMsgController {

	/*@Bean
    public MyHandler myHandler() {
        return new MyHandler();
    }*/
	
	@Autowired
	MyHandler myHandler;
	
	@RequestMapping("/tt")
    //@ResponseBody
    public String sendMsgToUser(HttpServletRequest request){
		String msg = "2016，与你相遇，猴幸运！";
    	String userCd = (String) request.getSession().getAttribute("USER_CD");
    	String msg2=(String) request.getParameter("msg");
    	if(msg2==null||msg2.equals("")){
    		msg2=msg;
		}
        myHandler.sendMessageToUser(userCd, new TextMessage(msg2));
        return "redirect:/web";
    }

    @RequestMapping("/chat/message")
	@ResponseBody
	public RespDataObj receiveMessage(@RequestBody String json){
		RespDataObj obj=new RespDataObj();
		try{
			Messages messages= JSON.parseObject(json,Messages.class);
			String msgtest = "2016，与你相遇，猴幸运！";
			String userId = messages.getTouserid()+"";
			String msg=messages.getPostmessage();
			if(msg==null||msg.equals("")){
				msg=msgtest;
			}
			myHandler.sendMessageToUser(userId, new TextMessage(msg));
		}catch (Exception e){
			e.printStackTrace();
		}
		obj.setSuccess(true);
		obj.setData("发送成功！");
		return obj;
	}

	@RequestMapping("/chat/test")
	@ResponseBody
	public RespDataObj testMessage(Messages messages){
		RespDataObj obj=new RespDataObj();
		try{
			String msgtest = "2016，与你相遇，猴幸运！";
			String userId = messages.getTouserid()+"";
			String msg=messages.getPostmessage();
			if(msg==null||msg.equals("")){
				msg=msgtest;
			}
			myHandler.sendMessageToUser(userId, new TextMessage(msg));
		}catch (Exception e){
			e.printStackTrace();
		}
		obj.setSuccess(true);
		obj.setData("发送成功！");
		return obj;
	}


}
