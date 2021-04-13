package com.zensar.userservice.service.serviceImpl;

import com.zensar.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {

    UserServiceImpl userService;
    List<User> list;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        list = new ArrayList<User>();
        list.add(new User(1, 1, "qui est esse", "est rerum tempore"));
        list.add(new User(1, 2, "sunt aut facere repellat provident", "quia et suscipit\nsuscipit recusandae"));
        list.add(new User(2, 3, "ea molestias quasi exercitationem repellat", "quia et suscipit"));
        list.add(new User(2, 4, "eum et est occaecati", "ullam et saepe reiciendis voluptatem adipisci"));
    }

    @Test
    void getCount() {
        assertEquals(4, userService.getCount(list));
    }

    @Test
    void getUniqueUserCount() {
        List<User> users = userService.getUniqueUserCount(list);
        assertEquals(2, users.size());
    }

    @Test
    void updateUser() {
        User userData=new User();
        userData.setTitle("Hello");
        userData.setBody("Welocme to Mobile Progeamming");
        List<User> users = userService.updateUser(list,userData, 4);
    }
}