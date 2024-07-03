package com.jvgroup.jvchatapp.service;

import com.jvgroup.jvchatapp.dao.UserRepository;
import com.jvgroup.jvchatapp.dto.UserDTO;
import com.jvgroup.jvchatapp.entity.User;
import com.jvgroup.jvchatapp.projection.UserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // conversion from projection to DTO
    private UserDTO convertToDTO(UserProjection userProjection) {
        if (userProjection == null) {
            return null;
        }
        return new UserDTO(userProjection.getName(), userProjection.getPhoneNumber(), userProjection.getEmail());
    }

    public List<UserDTO> getUsersByAccessGiven(boolean accessGiven) {
        List<UserProjection> projections = userRepository.findByAccessGiven(accessGiven);
        return projections.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserDTO getUserByPhoneNumber(String phoneNumber) {
        User user = userRepository.getUserByPhoneNumber(phoneNumber);
        return new UserDTO(user.getName(), user.getEmail(), user.getPhoneNumber());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

//        public List<UserDTO> getGroupsByUserId(Long groupId) {
//        List<UserProjection> groups = userRepository.findUserByGroupId(groupId);
//        return groups.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
}
