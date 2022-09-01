package com.kaede.myResources.controller;

import com.kaede.myResources.pojo.User;
import com.kaede.myResources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kaede
 * @create 2022-08-14 17:45
 */

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public Integer login(@RequestBody User user) {
        User user1 = userService.getUserByName(user.getUserName());
        if((user1 == null) || !user.getUserPassword().equals(user1.getUserPassword())) {
            return null;
        }
        return user1.getUserId();
    }

    @GetMapping("{id}")
    public User selectById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @PutMapping()
    public void update(@RequestBody User user) {
        userService.update(user);
    }

}
