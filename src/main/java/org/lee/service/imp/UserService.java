package org.lee.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.lee.dao.UserMapper;
import org.lee.service.IUserService;
import org.lee.vo.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserMapper userDao;

	@Override
	public User checkUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUsername(username);;
		user.setPassword(password);
		return userDao.checkUserInfo(user);
	}
   
}
