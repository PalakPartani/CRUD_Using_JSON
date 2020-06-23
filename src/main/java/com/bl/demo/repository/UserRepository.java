package com.bl.demo.repository;

import com.bl.demo.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;
    ObjectMapper objectMapper = new ObjectMapper();


    public UserRepository() {
        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/UserDetails.json"));
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {

            };
            userList = objectMapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return userList;
        //  return (List<User>) usersMap.values();
    }

    public User saveUser(User user) throws IOException {
        userList.add(user);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(new File("./src/main/resources/UserDetails.json"),user);
        return user;
    }

    public User getUSer(int id) {
        for (User users : userList) {
            if (users.getId() == id) {
                System.out.println("User id" + users.getId());
                return users;
            }
        }
        return null;
    }
     public void updateUser(Integer id,User user) throws IOException {
        User user1 = getUSer(id);
        userList.remove(user1);
        System.out.println(user1.getFirstName());
        System.out.println("user deleted");

        user.setId(id);
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        System.out.println(user1.getFirstName());
        System.out.println(user1.getId());

        saveUser(user);

    }
    public void deleteUserr(int id) throws IOException {
        User user = getUSer(id);
        userList.remove(user);
        objectMapper.writeValue(new File("./src/main/resources/UserDetails.json"), userList);

    }
}
