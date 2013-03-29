package com.his.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.his.dao.UserDao;
import com.his.model.User;

/**
 * 用户UserDao接口实现
 * @author wikimo
 *
 */
public class UserDaoImpl implements UserDao{
	
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 通过spring注入jdbcTemplate
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate =  jdbcTemplate;
	}
	
	/**
	 * 创建用户
	 */
	public int create(User user) {
		int result = 0;
		String sql = "insert into users(username,password)values(?,?)";
		result = this.jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword()});

		return result;
	}
	
	/**
	 * 更新用户
	 */
	public int update(User user) {
		int result = 0;
		String sql = "update users set username=?,password=? where id=?";
		result =  this.jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getId()});
		
		return result;
	}

	/**
	 * 删除用户
	 */
	public int delete(int id) {
		int result = 0;
		String sql = "delete from users  where id=?";
		result =  this.jdbcTemplate.update(sql,new Object[]{id});
		
		return result;
	}

	/**
	 * 根据id查找一个用户
	 */
	public User findById(int id) {
		String sql = "select * from users where id = ?";
		User user = null;
		user = (User)this.jdbcTemplate.queryForObject(sql, new Object[]{id},new RowMapper<User>(){
			public User mapRow(ResultSet rs, int index) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				return u;
			}
		});
		return user;
	}

	/**
	 * 根据条件查询用户列表
	 */
	public List<User> findByCondition(String condition) {
		//Todo sql注入
		String sql = "select * from users where " + condition;
		List<User> userList = new ArrayList<User>();
		
		List<Map> rows= (List)this.jdbcTemplate.queryForList(sql);
		for(Map row :rows){
			User user = new User();
			user.setId((Integer)row.get("id"));
			user.setUsername((String)row.get("username"));
			userList.add(user);
		}
		return userList;
	}

}
