package com.revature.models;

import com.revature.persistence.Column;
import com.revature.persistence.Entity;
import com.revature.persistence.Id;
import com.revature.persistence.Table;

@Entity
@Table(name = "test_1")
public class TestOne {
    @Id(type = "default")
    @Column(name = "id")
    private int id = 1;
    @Column(name = "name")
    private String title = "placeholder";
    @Column(name = "genre")
    private String genre = "generic";
    @Column(name = "on_fire")
    private boolean onFire = true;

    public TestOne() {
    }

    public TestOne(int id, String title, String genre, boolean onFire) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.onFire = onFire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }
}
