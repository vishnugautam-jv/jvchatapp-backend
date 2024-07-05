package com.jvgroup.jvchatapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jvgroup.jvchatapp.dao.ArrayStringListConverter;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    @Column(name = "text_message")
    private String textMessage;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "audio_path")
    private String audioPath;
    @Column(name = "video_path")
    @Convert(converter = ArrayStringListConverter.class)
    private List<String> videoPath;
    @Column(name = "image_path")
    @Convert(converter = ArrayStringListConverter.class)
    private List<String> imagePath;
    @Column(name = "reply_to_reference")
    private String replyToReference;
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "read_by")
    @Convert(converter = ArrayStringListConverter.class)
    private List<String> readBy;
    @Column(name = "seen_by")
    @Convert(converter = ArrayStringListConverter.class)
    private List<String> seenBy;
    @Column(name = "doc_path")
    @Convert(converter = ArrayStringListConverter.class)
    private List<String> docPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    @JsonBackReference
    private Group group = new Group();

    @Column(name = "sent_by_user")
    private String sentByUser;

    public Message(){}

    public Message(int chatId, String textMessage, String userName, String audioPath, List<String> videoPath, List<String> imagePath, String replyToReference, Timestamp timestamp, List<String> readBy, List<String> seenBy, List<String> docPath, Group group, String sentByUser) {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
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
}
