package com.local.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.dao.getUserListDao;
import com.local.introduce.HomeController;
import com.local.service.getUserListService;
import com.local.vo.getUserVo;

@Service
public class getUserListServiceImpl implements getUserListService {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	getUserListDao userdao;
	@Override
	public int userList(getUserVo vo) throws Exception {
		logger.debug("getUserListServiceImpl 의 userList 실행");
		return userdao.userBas(vo);
	}
	
	@Override
	public int saveUserInfo(getUserVo vo) throws Exception {
		logger.debug("getUserListServiceImpl 의 userList 실행");
		return userdao.saveUserInfo(vo);
	}

}
