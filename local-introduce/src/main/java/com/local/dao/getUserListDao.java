package com.local.dao;

import java.util.List;

import com.local.vo.getUserVo;

public interface getUserListDao {
	int userBas(getUserVo vo)throws Exception;
	int saveUserInfo(getUserVo vo)throws Exception;
}
