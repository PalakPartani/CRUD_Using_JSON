package com.bl.demo.dao;

import com.bl.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserDAO {
    static HashMap<Integer, User> usersMap = new HashMap<>();


    public UserDAO() {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("palu");
        user1.setLastName("ppp");

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("puja");
        user2.setLastName("ppp");

        usersMap.put(1, user1);
        usersMap.put(2, user2);
    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>(usersMap.values());
        return userList;
    }

}
