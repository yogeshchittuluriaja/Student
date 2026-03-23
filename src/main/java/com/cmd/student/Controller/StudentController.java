package com.cmd.student.Controller;

 

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserService userService;

        // Create user
        @PostMapping
        public User createUser(@RequestBody User user) {
            return userService.saveUser(user);
        }

        // Get all users
        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        // Get user by ID
        @GetMapping("/{id}")
        public Optional<User> getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
        }

        // Get user by Email
        @GetMapping("/email/{email}")
        public User getUserByEmail(@PathVariable String email) {
            return userService.getUserByEmail(email);
        }

        // Delete user
        @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return "User deleted successfully";
        }
    }

}
