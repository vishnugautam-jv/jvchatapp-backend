package com.jvgroup.jvchatapp.controller;

import com.jvgroup.jvchatapp.dao.UserGroupRepository;
import com.jvgroup.jvchatapp.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usergroups")
public class UserGroupController {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @PostMapping
    public UserGroup create(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }
}
