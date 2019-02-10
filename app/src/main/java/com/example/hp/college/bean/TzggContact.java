package com.example.hp.college.bean;

import com.example.hp.college.Activity.fragment.ShouyePageFragment;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TzggContact {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String title;
    @Property
    private String data;
    @Property
    private String date;
    @Generated(hash = 1346726406)
    public TzggContact(Long id, String title, String data, String date) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.date = date;
    }
    @Generated(hash = 1820715484)
    public TzggContact() {
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
    public String getDate(ShouyePageFragment shouyePageFragment) {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return this.date;
    }

}
