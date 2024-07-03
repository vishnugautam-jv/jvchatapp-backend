package com.jvgroup.jvchatapp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name="department")
    private String department;
    @Column(name="role")
    private String role;
    @Column(name = "is_super_admin")
    private boolean isSuperAdmin;
    @Column(name = "admin")
    private boolean admin;
    @Column(name="access_given")
    private boolean accessGiven;
    @Column(name = "created_time")
    private Timestamp createdTime;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "password")
    private String password;

    @Column(name = "last_approved_time")
    private Timestamp lastApprovedTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserGroup> userGroups = new HashSet<>();


    public User(){}

    public User(int id, String name, String email, String phoneNumber, String department, String role, boolean isSuperAdmin, boolean admin, boolean accessGiven, Timestamp createdTime, String shortDescription, String photoUrl, String password, Timestamp lastApprovedTime, Set<UserGroup> userGroups) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.role = role;
        this.isSuperAdmin = isSuperAdmin;
        this.admin = admin;
        this.accessGiven = accessGiven;
        this.createdTime = createdTime;
        this.shortDescription = shortDescription;
        this.photoUrl = photoUrl;
        this.password = password;
        this.lastApprovedTime = lastApprovedTime;
        this.userGroups = userGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAccessGiven() {
        return accessGiven;
    }

    public void setAccessGiven(boolean accessGiven) {
        this.accessGiven = accessGiven;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastApprovedTime() {
        return lastApprovedTime;
    }

    public void setLastApprovedTime(Timestamp lastApprovedTime) {
        this.lastApprovedTime = lastApprovedTime;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
