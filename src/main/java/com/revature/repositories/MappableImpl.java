package com.revature.repositories;

import java.util.LinkedList;

public class MappableImpl implements Mappable {
    @Override
    public void add(Object o) {
        //TODO: Use Reflection to get the values of the fields in the passed-in Object.
        //These fields will correspond with the columns in the db table.
        //TODO: Find a way to structure a JDBC PreparedStatement with variable fields/columns.
    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public LinkedList<Object> getAll() {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
