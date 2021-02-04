package com.FivePoints.Spring.controllers;

import com.FivePoints.Spring.models.User;
import com.FivePoints.Spring.payload.responses.MessageResponse;
import com.FivePoints.Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<MessageResponse> newUser(@RequestBody User newUser) {
        String message =  userService.addUser(newUser);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }

  @GetMapping("/findUser/{id}")
  ResponseEntity<?> findUser (@PathVariable("id") Integer id) {
        User user= userService.findUser(id);
        if(user!=null){
            return ResponseEntity.ok().body(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public  ResponseEntity<MessageResponse> deleteUser(@PathVariable("id") Integer id) {
        String message =  userService.deleteUser(id);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }

    @PutMapping("/UpdateUser/{id}")
    ResponseEntity<MessageResponse>  updateUser (@PathVariable("id") Integer id, @RequestBody User newUser) {
       String  message =  userService.updateUser(id,newUser);
        return  ResponseEntity.ok().body(new MessageResponse(message));
    }
    @GetMapping("/findUserByEmail/{email}")
    User User (@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }
}

