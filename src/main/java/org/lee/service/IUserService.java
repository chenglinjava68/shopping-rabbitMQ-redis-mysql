package org.lee.service;

import org.lee.vo.User;

public interface IUserService {
	public User checkUserInfo(String userName,String password);
}
