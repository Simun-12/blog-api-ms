package org.example.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "Operations related to users")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "Create User")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
