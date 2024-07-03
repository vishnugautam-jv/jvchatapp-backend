package com.jvgroup.jvchatapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jvgroup.jvchatapp.dao.ArrayStringListConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "group_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "group_super_admin")
    private String groupSuperAdmin;

    @Column(name = "group_admin")
    private String groupAdmin;

    @Column(name = "group_image")
    private String groupImage;

    @Column(name = "private_chat", nullable = false)
    private Boolean isPrivateChat = false;

    @Column(name = "group_members")
//    @Convert(converter = ArrayStringListConverter.class)
    private List<String> groupMembers;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserGroup> userGroups = new HashSet<>();

    public Group(){}

    public Group(int groupId, String groupName, String groupDescription, String groupSuperAdmin, String groupAdmin, String groupImage, Boolean isPrivateChat, List<String> groupMembers, List<Message> messages, Set<UserGroup> userGroups) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupSuperAdmin = groupSuperAdmin;
        this.groupAdmin = groupAdmin;
        this.groupImage = groupImage;
        this.isPrivateChat = isPrivateChat;
        this.groupMembers = groupMembers;
        this.messages = messages;
        this.userGroups = userGroups;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupSuperAdmin() {
        return groupSuperAdmin;
    }

    public void setGroupSuperAdmin(String groupSuperAdmin) {
        this.groupSuperAdmin = groupSuperAdmin;
    }

    public String getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(String groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }

    public Boolean getPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(Boolean privateChat) {
        isPrivateChat = privateChat;
    }

    public List<String> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<String> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}


