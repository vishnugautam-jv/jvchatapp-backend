package com.jvgroup.jvchatapp.dto;

import java.sql.Timestamp;
import java.util.List;

public class MessageDTO {

    private int chatId;
    private String textMessage;
    private String userName;
    private String audioPath;
    private List<String> videoPath;
    private List<String> imagePath;
    private String replyToReference;
    private Timestamp timestamp;
    private List<String> readBy;
    private List<String> seenBy;
    private List<String> docPath;
    private GroupDTO group;
    private String sentByUser;

    public MessageDTO(int chatId, String textMessage, String userName, String audioPath, List<String> videoPath, List<String> imagePath, String replyToReference, Timestamp timestamp, List<String> readBy, List<String> seenBy, List<String> docPath, GroupDTO group, String sentByUser) {
        this.chatId = chatId;
        this.textMessage = textMessage;
        this.userName = userName;
        this.audioPath = audioPath;
        this.videoPath = videoPath;
        this.imagePath = imagePath;
        this.replyToReference = replyToReference;
        this.timestamp = timestamp;
        this.readBy = readBy;
        this.seenBy = seenBy;
        this.docPath = docPath;
        this.group = group;
        this.sentByUser = sentByUser;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public List<String> getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(List<String> videoPath) {
        this.videoPath = videoPath;
    }

    public List<String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(List<String> imagePath) {
        this.imagePath = imagePath;
    }

    public String getReplyToReference() {
        return replyToReference;
    }

    public void setReplyToReference(String replyToReference) {
        this.replyToReference = replyToReference;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getReadBy() {
        return readBy;
    }

    public void setReadBy(List<String> readBy) {
        this.readBy = readBy;
    }

    public List<String> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<String> seenBy) {
        this.seenBy = seenBy;
    }

    public List<String> getDocPath() {
        return docPath;
    }

    public void setDocPath(List<String> docPath) {
        this.docPath = docPath;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public String getSentByUser() {
        return sentByUser;
    }

    public void setSentByUser(String sentByUser) {
        this.sentByUser = sentByUser;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
