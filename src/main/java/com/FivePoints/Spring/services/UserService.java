package com.FivePoints.Spring.services;

import com.FivePoints.Spring.models.User;
import com.FivePoints.Spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }
    public String addUser(User newUser) {
        userRepository.save(newUser);
         return "User added successfully" ;
    }

    public User findUser(Integer id) {
        return userRepository.findById(id).orElse(null);

    }
    public String deleteUser(Integer id){
         userRepository.deleteById(id);
         return "User deleted successfully";

    }
    public String updateUser(Integer id, User newUser) {
        User user= userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setAge(newUser.getAge());
            userRepository.save(user);
            return "User updated successfully";
        }
        else{
            return "user not found.";
        }
    }
    public User findUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    };
}