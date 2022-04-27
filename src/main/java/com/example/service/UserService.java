package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUser() throws Exception {
        return userMapper.selectUser();
    }

    public int addUser(User user) throws Exception {
        return userMapper.addUer(user);
    }


    public User login(String uName, String uPwd) throws Exception {
        return userMapper.login(uName, uPwd);
    }

    public void delete(int id) throws Exception {
        userMapper.delete(id);
    }

    public User select(int id) throws Exception{
        return userMapper.select(id);
    }

    public void update(User user) throws Exception{
        userMapper.update(user);
    }
}
