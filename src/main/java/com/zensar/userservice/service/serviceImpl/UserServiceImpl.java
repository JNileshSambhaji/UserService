package com.zensar.userservice.service.serviceImpl;

import com.zensar.userservice.model.User;
import com.zensar.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public long getCount(List<User> users) {

        return users.stream().count();
    }

    @Override
    public List<User> getUniqueUserCount(List<User> users) {

        List<User> userListFiltered = users.stream()
                .filter(distinctByKey(p -> p.getUserId()))
                .collect(Collectors.toList());

        System.out.println("Total Count= " + userListFiltered);

        return userListFiltered;
    }

    @Override
    public List<User> updateUser(List<User> user,User userData, int userId) {
        user.stream().forEach(k -> {
            if (k.getId() == userId) {
                k.setTitle(userData.getTitle());
                k.setBody(userData.getBody());
            }
        });
        return user;
    }

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
