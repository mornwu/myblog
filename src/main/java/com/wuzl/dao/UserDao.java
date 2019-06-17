package com.wuzl.dao;

import org.apache.ibatis.annotations.Param;

import com.wuzl.model.User;

public interface UserDao {
	public User selectByAccount(@Param("account") String account) throws Exception;

}
