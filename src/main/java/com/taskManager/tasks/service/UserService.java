package com.taskManager.tasks.service;

import com.taskManager.tasks.model.Users;
import java.util.List;

public interface UserService {
    public List<Users> getAllUsers();
    public void registerUser(Users user);
}
