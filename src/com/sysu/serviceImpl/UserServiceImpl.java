package com.sysu.serviceImpl;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysu.common.Assist;
import com.sysu.mapper.UserMapper;
import com.sysu.pojo.User;
import com.sysu.service.UserService;
import com.sysu.utils.Md5Encrypt;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
    
	@Override
	public User login(String userName, String password) {
//		UserExample example = new UserExample();
//		example.createCriteria().andUserNameEqualTo(userName).andPasswdEqualTo(Md5Encrypt.md5(password));
//		List<User> userList = userMapper.selectByExample(example);
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("username", userName), Assist.and_eq("password", Md5Encrypt.md5(password)));
		List<User> userList = userMapper.selectUser(assist);
		if(CollectionUtils.isEmpty(userList)){
			return null;
		}
		return userList.get(0);
	}
	
	@Override
	public int isExist(String userName) {
		Assist assist = new Assist();
		assist.setRequires(Assist.and_eq("username", userName));
		return (int) userMapper.getUserRowCount(assist);
	}

	@Override
	public int insertUser(User value) {
		return userMapper.insertUser(value);
	}

}