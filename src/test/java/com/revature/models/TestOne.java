package com.revature.models;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Table;

@Entity
@Table(name = "test_1")
public class TestOne {
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String title;
    @Column(name = "type")
    private String genre;
    @Column(name = "available")
    private boolean onFire;

    public TestOne() {
    }

    public TestOne(int id, String title, String genre, boolean onFire) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.onFire = onFire;
    }
}
