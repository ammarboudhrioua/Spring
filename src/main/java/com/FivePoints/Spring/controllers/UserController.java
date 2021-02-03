package com.FivePoints.Spring.controllers;

import com.FivePoints.Spring.models.User;
import com.FivePoints.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public List<User> all() {
        return userService.allUsers();
    }

    @PostMapping("/addUser")
    User newUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

  @GetMapping("/findUser/{id}")
         Optional<User> findUser (@PathVariable("id") Integer id) {
            return userService.findUser(id);
        }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {

        return userService.deleteUser(id);
    }
    @PutMapping("/UpdateUser/{id}")
    Optional<User> updateUser (@PathVariable("id") Integer id, @RequestBody User newUser) {
        return userService.updateUser(id,newUser);
    }

}

