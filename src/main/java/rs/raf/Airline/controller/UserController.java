package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.MyUser;
import rs.raf.Airline.repositories.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUserByUsername")
    public MyUser getUserByUsername(@RequestParam("username") String username) {
        return userRepository.findByUsername(username);
    }

}
