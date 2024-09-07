package com.taskManager.tasks.service.impl;

import com.taskManager.tasks.model.Users;
import com.taskManager.tasks.repository.UserDao;
import com.taskManager.tasks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    /**
     * Gets a list of all the users
     * @return List of users
     */
    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUser();
    }

    @Override
    public void registerUser(Users user) {
        userDao.registerUser(user);
    }
}
