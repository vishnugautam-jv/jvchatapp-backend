package com.jvgroup.jvchatapp.service;

import com.jvgroup.jvchatapp.dao.GroupRepository;
import com.jvgroup.jvchatapp.dto.GroupDTO;
import com.jvgroup.jvchatapp.entity.Group;
import com.jvgroup.jvchatapp.entity.UserGroup;
import com.jvgroup.jvchatapp.projection.GroupProjection;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

//     conversion from projection to DTO
    private GroupDTO convertToDTO(GroupProjection groupProjection) {
        if (groupProjection == null) {
            return null;
        }
        return new GroupDTO(groupProjection.getGroupId(), groupProjection.getGroupName(), groupProjection.getGroupSuperAdmin(), groupProjection.getGroupAdmin(), groupProjection.getGroupImage(), groupProjection.getIsPrivateChat(), groupProjection.getGroupMembers());

    }


    public List<GroupDTO> getGroupsByUserId(int userId) {
        List<GroupProjection> groups = groupRepository.findGroupsByUserId(userId);
        return groups.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    public List<GroupProjection> getGroups() {
        return groupRepository.findProjectedBy();
    }

}
