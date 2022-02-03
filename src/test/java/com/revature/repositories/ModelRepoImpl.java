package com.revature.repositories;

import java.util.List;

public class ModelRepoImpl implements ModelRepo {
    @Override
    public void addRecord() {
        /*
        * TODO:
        * Search for all fields with @Column.
        * Read the values stored in @Column annotations (which are the names of the columns in the db).
        * Take in the field values from dakaAdd(), which reads them from the object passed in.
        * Construct a JDBC PreparedStatement using the column names and dakaAdd() values. */
    }

    @Override
    public Object getRecord() {
        return null;
    }

    @Override
    public List<?> getAllRecords() {
        return null;
    }

    @Override
    public void updateRecord() {

    }

    @Override
    public void deleteRecord() {

    }
}
