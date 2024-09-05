package com.taskManager.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    public int user_id;
    public String username;
    public String password;
    public String first_name;
    public String last_name;
    public String email;
}
