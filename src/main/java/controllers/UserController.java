package controllers;

import lombok.RequiredArgsConstructor;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import repository.UserRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
        //System.out.println(users);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find user with id " + id));
    }

}
