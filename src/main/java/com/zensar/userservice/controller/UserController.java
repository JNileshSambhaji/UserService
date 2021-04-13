package com.zensar.userservice.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.userservice.model.User;
import com.zensar.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllCount")
    public long countUser() throws Exception {
        List<User> users = loadData();
        return userService.getCount(users);
    }

    @GetMapping("/getUniqueCount")
    public List<User> uniqueUser() throws Exception {
        List<User> users = loadData();
        return userService.getUniqueUserCount(users);  //al.stream().count();
    }

    @PutMapping("/updateUser/{userId}")
    public List<User> updateUser(@RequestBody User user, @PathVariable int userId) throws Exception {
        List<User> users = loadData();
        return userService.updateUser(users,user,userId);  //al.stream().count();
    }


    private List<User> loadData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User[] users = objectMapper.readValue(getClass().getResourceAsStream("/data.json"), User[].class);
        List<User> al = new ArrayList<>();
        for (User data : users) {
            al.add(data);
        }
        return al;
    }
}
