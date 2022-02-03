package com.revature.repositories;

import java.util.List;

public interface ModelRepo {
    public void addRecord();
    public Object getRecord();
    public List<?> getAllRecords();
    public void updateRecord();
    public void deleteRecord();
}
