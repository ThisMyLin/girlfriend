package com.db.entity;

import javax.persistence.*;

@Entity(name = "admin")
@Table(name = "admin")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private int admin_id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "is_super")
    private boolean ifSuper;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "adminId")
    private int adminId;

    public User() {
    }

    public User(String avatar, int groupId, String groupName, boolean ifSuper, String name, String password, int adminId) {
        this.avatar = avatar;
        this.groupId = groupId;
        this.groupName = groupName;
        this.ifSuper = ifSuper;
        this.name = name;
        this.password = password;
        this.adminId = adminId;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public boolean isIfSuper() {
        return ifSuper;
    }

    public void setIfSuper(boolean ifSuper) {
        this.ifSuper = ifSuper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "User{" +
                "admin_id=" + admin_id +
                ", avatar='" + avatar + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", ifSuper=" + ifSuper +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
