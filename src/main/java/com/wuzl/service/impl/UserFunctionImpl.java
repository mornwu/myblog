package com.wuzl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuzl.common.ThisSystemException;
import com.wuzl.common.ThisSystemUtil;
import com.wuzl.dao.UserDao;
import com.wuzl.model.User;
import com.wuzl.service.UserFunction;

@Service
public class UserFunctionImpl implements UserFunction {
	@Autowired
	UserDao udao;

	public User login(String account, String password) throws Exception {
		account = ThisSystemUtil.throwIfBlank("账户不能为空", account);
		password = ThisSystemUtil.throwIfBlank("密码不能为空", password);

		User u = udao.selectByAccount(account);
		if (u == null) {
			throw new ThisSystemException("用户不存在");
		}
		if (!u.getPassword().equals(password)) {
			throw new ThisSystemException("密码错误");
		}

		return u;
	}

}
