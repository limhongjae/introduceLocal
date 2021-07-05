package com.local.introduce;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.local.service.getUserListService;
import com.local.vo.getUserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/localLogin") 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	getUserListService userbas;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String tshowLogin(Locale locale, Model model) {
		
		
		return "/Login/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showLogin(Locale locale, Model model) {
		
		
		return "/Login/login";
	}
	
	@RequestMapping(value = "/signUpInfo", method = RequestMethod.GET)
	public String signUpInfo(Locale locale, Model model) {
		return "/SignUp/signUpInfo";
	}
	
	@RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> saveUserInfo(@RequestBody getUserVo vo)throws Exception {
		HashMap< String,Object> successMap  = new HashMap< String,Object>();
		logger.debug("======== saveUserInfo 실행 ===========");
		logger.debug("userId : "+ vo.getUserId());
		logger.debug("userPw : "+ vo.getUserPw());
		
		int saveUserinfo = userbas.saveUserInfo(vo);
		successMap.put("msg", saveUserinfo);
		
		return successMap;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public @ResponseBody  HashMap<String, Object> checkLogin (@RequestBody getUserVo vo) throws Exception{
		HashMap< String,Object> returnCheckUser  = new HashMap< String,Object>();
		String msg = "";
		int checkUserInfo = userbas.userList(vo);
		if(checkUserInfo <= 0) {
			msg = "true";  //아이디 사용가능
		}else if(checkUserInfo > 0) {
			msg = "false"; //아이디 사용불가
		}

		returnCheckUser.put("msg", msg);
		
		return returnCheckUser;
	}
	
}
