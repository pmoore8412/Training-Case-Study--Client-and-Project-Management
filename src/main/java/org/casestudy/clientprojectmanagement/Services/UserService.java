package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.User;
import org.casestudy.clientprojectmanagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User newUser(User user) {

        Optional<User> savedUser = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if(savedUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "User with email " + user.getEmail() + " already exists");
        }

        return userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    public User getUser (String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No user found with id: " + id));
    }

    public User login(String email, String password) {

        Optional<User> loginUser = Optional.ofNullable(userRepository.findByEmail(email));

        if(loginUser.isPresent()) {
            if(password.equals(loginUser.get().getPassword())) {
                return loginUser.get();
            }
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Either email or password is incorrect");

    }

    public User updateUser(String id, User user) {

        Optional<User> updatedUser = userRepository.findById(id);

        if(updatedUser.isPresent()) {
            updatedUser.get().setFirstName(user.getFirstName());
            updatedUser.get().setLastName(user.getLastName());
            updatedUser.get().setEmail(user.getEmail());
            updatedUser.get().setPassword(user.getPassword());

            user = updatedUser.get();
        }

        return userRepository.save(user);

    }

    public User adminUpdateUser(String id, User user) {
        Optional<User> adminUpdate = userRepository.findById(id);

        if(adminUpdate.isPresent()) {
            adminUpdate.get().setAdmin(user.isAdmin());

            user = adminUpdate.get();
        }

        return userRepository.save(user);

    }

    public void removeUser(String id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No user found with id: " + id));

        userRepository.delete(user);
    }

}
