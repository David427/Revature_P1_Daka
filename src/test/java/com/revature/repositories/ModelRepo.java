package com.revature.repositories;

public interface ModelRepo {
    //Paramter: Object o
    public void addRecord();
    //Parameter String tableName, int id
    public void getRecord();
    //Parameter String tableName
    public void getAllRecords();
    //Parameter Object o
    public void updateRecord();
    //Parameter Object o
    public void deleteRecord();
}
