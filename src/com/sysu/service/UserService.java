package com.sysu.service;
import java.util.List;
import com.sysu.pojo.User;
import com.sysu.common.Assist;
public interface UserService{
	public User login(String userName, String password);
	public int isExist(String userName);
	public int insertUser(User value);
}