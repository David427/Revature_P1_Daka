package com.revature.repositories;

import com.revature.annotations.Entity;

import java.util.LinkedList;

/**
 *
 */
@Entity
public interface Mappable {
    public void add(Object o);
    public Object get(Object o);
    public LinkedList<Object> getAll();
    public void update(Object o);
    public void delete(Object o);
}
