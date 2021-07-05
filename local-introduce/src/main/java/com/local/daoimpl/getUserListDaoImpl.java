package com.local.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.local.dao.getUserListDao;
import com.local.introduce.HomeController;
import com.local.vo.getUserVo;

@Repository
public class getUserListDaoImpl implements getUserListDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private SqlSession sqlsession; 
	
	private static final String namspace = "com.local.getUserBas.";
	@Override
	public int  userBas(getUserVo vo) throws Exception {
		 logger.debug("getUserListDaoImpl 의 userBas 실행 : "+ namspace);
		return sqlsession.selectOne(namspace+"getUserList", vo);
	}
	@Override
	public int saveUserInfo(getUserVo vo) throws Exception {
		 logger.debug("getUserListDaoImpl 의 saveUserInfo 실행");
		return sqlsession.insert(namspace+"insertUserInfo", vo);
	}
	
}
