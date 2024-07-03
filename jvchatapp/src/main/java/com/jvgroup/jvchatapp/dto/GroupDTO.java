package com.jvgroup.jvchatapp.dto;

import java.util.List;

public class GroupDTO {

    private int groupId;
    private String groupName;
    private String groupSuperAdmin;
    private String groupAdmin;
    private String groupImage;
    private boolean isPrivateChat;
    private List<String> groupMembers;

    public GroupDTO(){}

    public GroupDTO(int groupId, String groupName, String groupSuperAdmin, String groupAdmin, String groupImage, boolean isPrivateChat, List<String> groupMembers) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupSuperAdmin = groupSuperAdmin;
        this.groupAdmin = groupAdmin;
        this.groupImage = groupImage;
        this.isPrivateChat = isPrivateChat;
        this.groupMembers = groupMembers;
    }

    public List<String> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<String> groupMembers) {
        this.groupMembers = groupMembers;
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

    public boolean isPrivateChat() {
        return isPrivateChat;
    }

    public void setPrivateChat(boolean privateChat) {
        isPrivateChat = privateChat;
    }
}
