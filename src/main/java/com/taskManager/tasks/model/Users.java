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
    public int id;
    public String username;
    public String pass;
    public String firstname;
    public String lastname;
    public String email;
}
