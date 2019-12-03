package com.leszek.demoapp.domain.Repositories;

import com.leszek.demoapp.domain.Task;
import com.leszek.demoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findByUser(User user);
}
