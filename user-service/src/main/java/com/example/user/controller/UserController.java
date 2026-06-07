package com.example.user.controller;

import com.example.user.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    // 模拟数据库
    private static final Map<Long, User> USER_DB = new HashMap<>();

    static {
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setEmail("zhangsan@example.com");
        USER_DB.put(1L, user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return USER_DB.get(id);
    }

}
