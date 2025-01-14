package org.example.onlinestore.Repository;

import org.example.onlinestore.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>(List.of(
            new User(1,"Murad"),
            new User(2,"Nasir"),
            new User(3,"Ali"),
            new User(4,"Rufat")
    ));

    public List<User> getUsers() {
        return users;
    }

    public User getUserByUserId(int id) {
        return users.stream().filter(user->user.getUserid()==id).
                 findFirst().orElseThrow(()->new RuntimeException("User not found"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUserByUserId(int id) {
        users.removeIf(user->user.getUserid()==id);
    }

}
