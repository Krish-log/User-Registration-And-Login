package UserRegistrationAndLogin.UserRegistrationAndLogin.Controllers;

import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.User;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Repositories.UserRepository;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Encode password and create new user
        User newUser = User.builder()
                            .username(user.getUsername())
                            .password(encoder.encode(user.getPassword()))
                            .email(user.getEmail())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .build();

        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
