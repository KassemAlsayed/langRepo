package com.kass.lang.domain;

import javax.persistence.*;

/**
 * Created by kass on 2017-10-08.
 */
@Entity
public class Language {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String name;
    private String icon;
    private String comment;
    public Language() {
    }

    public Language(String name, String icon, String comment, int id) {
        super();
        this.name = name;
        this.icon = icon;
        this.comment = comment;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }
}
