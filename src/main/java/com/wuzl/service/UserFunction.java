package com.wuzl.service;

import com.wuzl.model.User;

public interface UserFunction {
	public User login(String account, String password) throws Exception;

}
