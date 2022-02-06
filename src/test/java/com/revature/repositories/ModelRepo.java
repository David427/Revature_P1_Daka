package com.revature.repositories;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ModelRepo {
    //Paramter: Object o
    public void addRecord();
    //Parameter String tableName, int id
    public Object getRecord() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    //Parameter String tableName
    public List<?> getAllRecords() throws ClassNotFoundException;
    //Parameter Object o
    public void updateRecord();
    //Parameter Object o
    public void deleteRecord();
}
