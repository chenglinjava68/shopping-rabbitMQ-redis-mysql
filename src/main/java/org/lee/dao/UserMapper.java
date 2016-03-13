package org.lee.dao;

import org.springframework.stereotype.Repository;

import org.lee.vo.User;

@Repository
public interface UserMapper {
	public User checkUserInfo(User user);

}
