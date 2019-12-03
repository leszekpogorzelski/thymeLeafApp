package com.leszek.demoapp.service;

import com.leszek.demoapp.domain.Repositories.TaskRepository;
import com.leszek.demoapp.domain.Task;
import com.leszek.demoapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTasks(User user) {
        return taskRepository.findByUser(user);
    }
}
