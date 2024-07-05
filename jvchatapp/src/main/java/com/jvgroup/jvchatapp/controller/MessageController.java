package com.jvgroup.jvchatapp.controller;

import com.jvgroup.jvchatapp.dao.GroupRepository;
import com.jvgroup.jvchatapp.dao.MessageRepository;
import com.jvgroup.jvchatapp.dto.MessageDTO;
import com.jvgroup.jvchatapp.entity.Group;
import com.jvgroup.jvchatapp.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private GroupRepository groupRepository;

    @PostMapping("/{groupId}/messages")
    public ResponseEntity<Message> createMessageForGroup(
            @PathVariable int groupId,
            @RequestBody MessageDTO messageDTO) {

        // Fetch the existing group from the database
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group ID"));


        // Create a new Message and set its properties from the DTO
        Message message = new Message();
        message.setTextMessage(messageDTO.getTextMessage());
        message.setUserName(messageDTO.getUserName());
        message.setAudioPath(messageDTO.getAudioPath());
        message.setVideoPath(messageDTO.getVideoPath());
        message.setImagePath(messageDTO.getImagePath());
        message.setReplyToReference(messageDTO.getReplyToReference());
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        message.setReadBy(messageDTO.getReadBy());
        message.setSeenBy(messageDTO.getSeenBy());
        message.setDocPath(messageDTO.getDocPath());
        message.setSentByUser(messageDTO.getSentByUser());

        // Set the group to the existing group fetched from the database
        message.setGroup(group);

        // Save the message entity
        Message savedMessage = messageRepository.save(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }
}
