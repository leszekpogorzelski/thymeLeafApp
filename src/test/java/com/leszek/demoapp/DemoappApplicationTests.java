package com.leszek.demoapp;

import com.leszek.demoapp.domain.Task;
import com.leszek.demoapp.domain.User;
import com.leszek.demoapp.service.TaskService;
import com.leszek.demoapp.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoappApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @Test
    public void testUser(){
        User user = new User("testuser@user.com", "testuser", "testuser");
        userService.createUser(user);

        User admin = new User("testadmin@user.com", "testadmin", "testadmin");
        userService.createUser(admin);


        Task userTask = new Task("21-10-2019", "21-10-2019", "21-10-2019", "testuser");

        taskService.addTask(userTask, user);

        Optional<User> findUser = userService.findOne("testuser@user.com");
        Assert.assertEquals("testuser", findUser.get().getName());
        Optional<User> findAdmin = userService.findOne("testadmin@user.com");
        Assert.assertEquals("testadmin", findAdmin.get().getName());
    }

    @Test
    public void testTask() {
        User user = new User("testuser@user.com", "testuser", "testuser");
        userService.createUser(user);

        User admin = new User("testadmin@user.com", "testadmin", "testadmin");
        userService.createUser(user);


        Task userTask = new Task("21-10-2019", "21-10-2019", "21-10-2019", "testuser");

        taskService.addTask(userTask, user);

        Optional<User> findUser = userService.findOne("testuser@user.com");
        List<Task> task = taskService.findUserTasks(findUser.get());
        Assert.assertNotNull(task);

    }
}
