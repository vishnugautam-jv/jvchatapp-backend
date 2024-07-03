package com.jvgroup.jvchatapp.controller;


import com.jvgroup.jvchatapp.dto.GroupDTO;
import com.jvgroup.jvchatapp.projection.GroupProjection;
import com.jvgroup.jvchatapp.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/list")
    public List<GroupProjection> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/user/{user_id}")
    public List<GroupDTO> getGroupsByUserId(@PathVariable int user_id) {
        return groupService.getGroupsByUserId(user_id);
    }
}
