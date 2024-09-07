package com.taskManager.tasks.repository;

import com.taskManager.tasks.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<Users> getAllUser();

    Users getUserByUsername(String username);

    public void registerUser(Users user);
}
