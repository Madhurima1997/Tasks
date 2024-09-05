package com.taskManager.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    public int task_id;
    public String task_title;
    public String task_description;
    public int task_priority;
}
