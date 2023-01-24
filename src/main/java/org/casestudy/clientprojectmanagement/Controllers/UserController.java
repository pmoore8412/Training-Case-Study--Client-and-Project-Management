package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.User;
import org.casestudy.clientprojectmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/new-user")
    public User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(name = "id") String id) {
        return userService.getUser(id);
    }

    @PostMapping("/user/login")
    public User login(@RequestHeader(name = "email") String email, @RequestHeader(name = "password") String password) {
        return userService.login(email, password);
    }

    @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable(name = "id") String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PutMapping("/user/admin/update/{id}")
    public User adminUpdateUser(@PathVariable(name = "id") String id, @RequestBody User user) {
        return userService.adminUpdateUser(id, user);
    }

    @DeleteMapping("/user/remove/{id}")
    public void removeUser(@PathVariable(name = "id") String id) {
        userService.removeUser(id);
    }

}
