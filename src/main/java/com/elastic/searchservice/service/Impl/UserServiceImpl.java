package com.elastic.searchservice.service.Impl;

import com.elastic.searchservice.model.User;
import com.elastic.searchservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepository usersRepository;
    @Override
//    @CacheEvict(value = "users", allEntries = true)
//    @Scheduled(fixedRate = 15000)
    public List<User> getAllUsers() {
        Iterator<User> users= usersRepository.findAll().iterator();
        List<User> usersList = new ArrayList<>();
        while (users.hasNext()) {
            usersList.add(users.next());
        }
        return usersList;
    }
}
