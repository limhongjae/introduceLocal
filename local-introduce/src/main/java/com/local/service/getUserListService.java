package com.local.service;

import java.util.List;

import com.local.vo.getUserVo;

public interface getUserListService{
	
	int userList(getUserVo vo)throws Exception;
	int saveUserInfo(getUserVo vo)throws Exception;
}
