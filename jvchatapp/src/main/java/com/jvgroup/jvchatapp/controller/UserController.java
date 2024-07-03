package com.jvgroup.jvchatapp.controller;

import com.jvgroup.jvchatapp.dto.UserDTO;
import com.jvgroup.jvchatapp.entity.User;
import com.jvgroup.jvchatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/access")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/phone/{phone_number}")
    public UserDTO findUserByPhoneNumber(@PathVariable String phone_number){
        return userService.getUserByPhoneNumber(phone_number);
    }

    @GetMapping("/access/{access_given}")
    public List<UserDTO> getUsersByAccessGiven(@PathVariable Boolean access_given) {
        return userService.getUsersByAccessGiven(access_given);
    }

//    @GetMapping("/group/{group_id}")
//    public List<UserDTO> getGroupsByUserId(@PathVariable Long group_id) {
//        return userService.getGroupsByUserId(group_id);
//    }
}

