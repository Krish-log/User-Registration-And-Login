package UserRegistrationAndLogin.UserRegistrationAndLogin.Controllers;

import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.MessageResponse;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.User;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username not found!"));
        }

        User existingUser = userRepository.findByUsername(user.getUsername()).get();

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid password!"));
        }

        return ResponseEntity.ok(new MessageResponse("User logged in successfully!"));
    }
}