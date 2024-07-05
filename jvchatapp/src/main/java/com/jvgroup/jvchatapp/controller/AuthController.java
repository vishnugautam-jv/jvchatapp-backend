package com.jvgroup.jvchatapp.controller;

import com.jvgroup.jvchatapp.dao.UserRepository;
import com.jvgroup.jvchatapp.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // final is the javascript equivalent for const
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest signInRequest) {
        User user = userRepository.getUserByPhoneNumber(signInRequest.getPhoneNumber());
        if (user == null || !user.getPassword().equals(signInRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        // Successful sign-in logic here
        return ResponseEntity.ok("Sign-in successful");
    }

    static class SignInRequest {
        private String phoneNumber;
        private String password;

        // Getters, setters


        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

