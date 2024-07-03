package com.jvgroup.jvchatapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_group")
public class UserGroup {

    @EmbeddedId
    private UserGroupKey id;

    // many usergroup is associated with one user
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // many usergroup is associated with one group
    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;

    public UserGroup(){}

    public UserGroup(UserGroupKey id, User user, Group group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public UserGroupKey getId() {
        return id;
    }

    public void setId(UserGroupKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
