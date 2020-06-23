package com.bl.demo.service;

import com.bl.demo.dao.UserDAO;
import com.bl.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    public List<User> getAllUsers() {
        List<User> userList = userDao.getAllUsers();
        return userList;
    }

}
