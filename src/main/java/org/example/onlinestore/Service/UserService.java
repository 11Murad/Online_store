package org.example.onlinestore.Service;

import lombok.RequiredArgsConstructor;
import org.example.onlinestore.Entity.User;
import org.example.onlinestore.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getUsers();
    }

    public User getUserByUserId(int id) {
        return userRepository.getUserByUserId(id);
    }

    public void addUser(User user) {
    userRepository.addUser(user);
    }

    public void deleteUserByUserId(int id) {
        userRepository.deleteUserByUserId(id);
    }



}
