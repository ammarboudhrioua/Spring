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

    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);

    }
    public String deleteUser(Integer id){
         userRepository.deleteById(id);
         return "deleted";

    }
    public Optional<User> updateUser(Integer id, User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setAge(newUser.getAge());
                    return userRepository.save(user);
                });

    }
}