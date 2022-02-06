package com.revature.models;

import com.revature.persistence.Column;
import com.revature.persistence.Entity;
import com.revature.persistence.Id;
import com.revature.persistence.Table;

@Entity
@Table(name = "test_2")
public class TestTwo {
    @Id(type = "default")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "available")
    private boolean available;

    public TestTwo() {
    }

    public TestTwo(int id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    @Override
    public String toString() {
        return "TestTwo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
