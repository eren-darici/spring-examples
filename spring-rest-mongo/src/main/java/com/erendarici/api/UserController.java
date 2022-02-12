package com.erendarici.api;

import com.erendarici.entity.User;
import com.erendarici.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstname("Eren");
        user.setLastname("the Second");
        HashMap<String, String> specs = new HashMap<>();
        specs.put("Age", "20");
        specs.put("Height", "183");
        user.setSpecs(specs);
        userRepository.save(user);

    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }


}
