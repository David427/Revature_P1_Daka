package com.revature.models;

import com.revature.persistence.Column;
import com.revature.persistence.Entity;
import com.revature.persistence.Table;

@Entity
@Table(name = "test_2")
public class TestTwo {
    @Column(name = "id")
    private int id = 2;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "available")
    private boolean available;

    public TestTwo() {
    }

    public TestTwo(int id, String name, String type, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
    }
}
