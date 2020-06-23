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

    public UserRepository() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = new FileInputStream(new File("./src/main/resources/UserDetails.json"));
            // TypeReference<HashMap<Integer,User>> typeReference = new TypeReference<HashMap<Integer,User>>() {
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {

            };
            userList = mapper.readValue(inputStream, typeReference);
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
}
