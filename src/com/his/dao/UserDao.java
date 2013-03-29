package com.his.dao;

import java.util.List;

import com.his.model.User;

/**
 * 定义了User数据操作接口
 * @author wikimo
 *
 */
public interface UserDao {
	public int create(User user);
	
	public int update(User user);
	
	public int delete(int id);
	
	public User findById(int id);
	
	public List<User> findByCondition(String condition);
}
