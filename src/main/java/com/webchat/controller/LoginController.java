package com.webchat.controller;

import com.webchat.pojo.UserNew;
import com.webchat.pojo.util.ParticipantRepository;
import com.webchat.pojo.util.RespDataObj;
import com.webchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Description: 登录(将用户存入session)
 * @author: che
 * @Date: 2016年1月1日 下午7:28:17
 */
@Controller
public class LoginController {

	@Autowired
	private ParticipantRepository participantRepository; //在线用户存储
	@Autowired
	private UserService userService;


	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		// form表单提交用户登录账号密码
		
		// 查询DB该用户密码是否正确
		
		// 正确:将userCd存入session
		request.getSession().setAttribute("USER_CD", "3");
		return "/main";
	}

	@RequestMapping("/chat/login")
	@ResponseBody
	public RespDataObj login2(UserNew user,HttpServletRequest request) {
		RespDataObj obj=new RespDataObj();
		String userId=user.getUserid();
		String password=user.getPassword();
		UserNew check=new UserNew();
		// form表单提交用户登录账号密码
		try{
			if((userId!=null&&userId.length()!=0)){
				check=userService.queryUserById(userId);
				if(check!=null){//判断数据库中是否存在该用户
					if(!StringUtils.isEmpty(password)&&password.equals(check.getPassword())){//判断密码是否匹配
						// 正确:将userCd存入session
						request.getSession().setAttribute("USER_CD", userId);
						request.getSession().setAttribute("USER_NAME", check.getNickname());
						//在线人数


						obj.setSuccess(true);
						obj.setData("登录成功！");
						return obj;
					}else {
						throw new Exception("请输入正确的密码！");
					}
				}else {
					throw new Exception("该用户不存在！");
				}
			}else {
				throw new Exception("请输入用户名！");
			}
		}catch (Exception e){
			e.printStackTrace();
			obj.setSuccess(false);
			obj.setData("登录失败！");
			return obj;
		}
		// 查询DB该用户密码是否正确
	}
	
	@RequestMapping("/web")
	public String dispatch(HttpServletRequest request) {
		return "/websocketTest";
	}

	/**
	 * 返回当前在线人数
	 * @return
	 */
	@RequestMapping("/chat/participants")
	public Long getActiveUserNumber(){
		return Long.valueOf(participantRepository.getActiveSessions().values().size());
	}
}
