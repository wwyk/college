package com.example.hp.college.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class XydtContact {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String title;
    @Property
    private String data;
    @Property
    private String date;
    @Generated(hash = 1370516173)
    public XydtContact(Long id, String title, String data, String date) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.date = date;
    }
    @Generated(hash = 843290268)
    public XydtContact() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
