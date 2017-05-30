package com.sysu.serviceImpl;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sysu.mapper.UserDao;
import com.sysu.pojo.User;
import com.sysu.pojo.UserExample;
import com.sysu.common.Assist;
import com.sysu.service.UserService;
import com.sysu.utils.Md5Encrypt;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    
	@Autowired 
	private com.sysu.mapper.UserMapper userMapper;
    
	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName).andPasswdEqualTo(Md5Encrypt.md5(password));
		List<User> userList = userMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(userList)){
			return null;
		}
		
		return userList.get(0);
	}
    
    @Override
    public long getUserRowCount(Assist assist){
        return userDao.getUserRowCount(assist);
    }
    @Override
    public List<User> selectUser(Assist assist){
        return userDao.selectUser(assist);
    }
    @Override
    public User selectUserById(Integer id){
        return userDao.selectUserById(id);
    }
    @Override
    public int insertUser(User value){
        return userDao.insertUser(value);
    }
    @Override
    public int insertNonEmptyUser(User value){
        return userDao.insertNonEmptyUser(value);
    }
    @Override
    public int deleteUserById(Integer id){
        return userDao.deleteUserById(id);
    }
    @Override
    public int deleteUser(Assist assist){
        return userDao.deleteUser(assist);
    }
    @Override
    public int updateUserById(User enti){
        return userDao.updateUserById(enti);
    }
    @Override
    public int updateUser(User value, Assist assist){
        return userDao.updateUser(value,assist);
    }
    @Override
    public int updateNonEmptyUserById(User enti){
        return userDao.updateNonEmptyUserById(enti);
    }
    @Override
    public int updateNonEmptyUser(User value, Assist assist){
        return userDao.updateNonEmptyUser(value,assist);
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}