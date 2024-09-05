package com.taskManager.tasks.repository;

import com.taskManager.tasks.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserDao {
    List<Users> getAllUser();
}
