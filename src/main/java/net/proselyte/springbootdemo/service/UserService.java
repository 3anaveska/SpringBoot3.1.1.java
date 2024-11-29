package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> findAllUsers();
    User findUserById(Long id);
    void deleteById(Long id);
}
