package com.bl.demo.service;

import com.bl.demo.model.User;
import com.bl.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return userList;
    }
    public User add(User user) throws IOException {
        return userRepository.saveUser(user);
    }
    public void update(Integer id,User user) throws IOException {
        userRepository.updateUser(id,user);
    }
    public void delete(int id) throws IOException {
        userRepository.deleteUserr(id);
    }
}
