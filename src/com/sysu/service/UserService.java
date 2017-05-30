package com.sysu.service;
import java.util.List;
import com.sysu.pojo.User;
import com.sysu.common.Assist;
public interface UserService{
    long getUserRowCount(Assist assist);
    List<User> selectUser(Assist assist);
    User selectUserById(Integer id);
    int insertUser(User value);
    int insertNonEmptyUser(User value);
    int deleteUserById(Integer id);
    int deleteUser(Assist assist);
    int updateUserById(User enti);
    int updateUser(User value, Assist assist);
    int updateNonEmptyUserById(User enti);
    int updateNonEmptyUser(User value, Assist assist);
    
	public User login(String userName, String password);
}