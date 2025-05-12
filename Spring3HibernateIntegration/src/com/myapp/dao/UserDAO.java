package com.myapp.dao;

import java.util.List;

import com.myapp.entity.User;

public interface UserDAO {
	public void insertData(User user);

	public List<User> getUserList();

	public void updateData(User user);

	public void deleteData(Integer id);

	public User getUser(Integer id);
    public String getExistFirstname(String firstname);

}
