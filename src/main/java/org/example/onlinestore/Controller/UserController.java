package org.example.onlinestore.Controller;
import lombok.RequiredArgsConstructor;
import org.example.onlinestore.Entity.User;
import org.example.onlinestore.Service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
    return userService.getUserByUserId(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserByUserId(id);
    }



}
