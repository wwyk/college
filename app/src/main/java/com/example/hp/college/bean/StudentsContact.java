package com.example.hp.college.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class StudentsContact {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String stuname;
    @Property
    private String username;
    @Property
    private String userpsw;
    @Generated(hash = 1275396344)
    public StudentsContact(Long id, String stuname, String username,
            String userpsw) {
        this.id = id;
        this.stuname = stuname;
        this.username = username;
        this.userpsw = userpsw;
    }
    @Generated(hash = 68059078)
    public StudentsContact() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStuname() {
        return this.stuname;
    }
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpsw() {
        return this.userpsw;
    }
    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw;
    }


}