package UserRegistrationAndLogin.UserRegistrationAndLogin.Controllers;

import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.LoginRequest;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.MessageResponse;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.User;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Repositories.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username not found!"));
        }

        User existingUser = userOptional.get();

        // Verify password
        if (!passwordEncoder.matches(loginRequest.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid password!"));
        }

        return ResponseEntity.ok(new MessageResponse("User logged in successfully!"));
    }

}