package blog.api.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import blog.api.model.User;
import blog.api.repository.UserRepository;
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
    @GetMapping("/getAlLUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "Create User")
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @Operation(summary = "Delete User by Id")
    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable String userId){
        userRepository.deleteById(userId);
    }

    @Operation(summary = "Update user profile")
    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUserName(updatedUser.getUserName());
                    user.setFullName(updatedUser.getFullName());
                    user.setEmail(updatedUser.getEmail());
                    user.setBio(updatedUser.getBio());
                    user.setDob(updatedUser.getDob());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
    }
}


