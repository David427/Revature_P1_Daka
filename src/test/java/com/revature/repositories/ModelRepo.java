package com.revature.repositories;

import java.util.List;

public interface ModelRepo {
    //Paramter: Object o
    public void addRecord();
    //Parameter String table, int id
    public Object getRecord();
    //Parameter String table
    public List<?> getAllRecords();
    //Parameter Object o, String table, int id
    public void updateRecord();
    //Parameter String table, int id
    public void deleteRecord();
}
