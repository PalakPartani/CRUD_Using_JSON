package com.bl.demo;

import com.bl.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
       /* try{
        ObjectMapper objectMapper=new ObjectMapper();
        InputStream inputStream=new FileInputStream(new File("/"));
            TypeReference typeReference=new TypeReference(1) {};
            List<User> users=objectMapper.readValue(inputStream,typeReference);
            for(User user:users){
                System.out.println("name"+user.getFirstName());
            }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }*/
    }
}
