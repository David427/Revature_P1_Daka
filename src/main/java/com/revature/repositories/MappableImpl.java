package com.revature.repositories;

import com.revature.util.JdbcConnection;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

public class MappableImpl implements Mappable {

    Connection connection = JdbcConnection.getConnection();

    @Override
    public void add(Object o) {
        //TODO: Add table name as a parameter

        Class<?> c = o.getClass();              //generic class
        Field[] fields = c.getDeclaredFields(); //all fields of object
        int len = fields.length;                //amount of fields

        //Build column names and ?'s for the sql query
        String cn = ""; //column names
        String qm = ""; //question marks
        for(int i = 0;i < len;i++) {
            fields[i].setAccessible(true);
            try {
                cn += fields[i].getName();
                qm += "?";
                if (i < len - 1) {
                    cn += ", ";
                    qm += ",";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(cn);
        System.out.println(qm);


        String tableName = "myTables"; //TODO: comment out when table name is a parameter
        String sql = "INSERT INTO " + tableName + " (" + cn + ") VALUES (" + qm + ") RETURNING *";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0;i < len;i++) {
                switch(fields[i].getType().toString()) {
                    case "int": ps.setInt((i+1), fields[i].getInt(o)); break;
                    case "long": ps.setLong((i+1), fields[i].getLong(o)); break;
                    case "short": System.out.println("ps.setShort(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    case "byte": System.out.println("ps.setByte(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    case "class java.lang.String": System.out.println("ps.setString(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    case "boolean": System.out.println("ps.setBoolean(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    case "double": System.out.println("ps.setDouble(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    case "float":System.out.println("ps.setFloat(" + (i+1) + ", " + fields[i].get(o) + ")"); break;
                    default: System.out.println("Unsupported: " + fields[i].getType().toString());
                }
            }

            ResultSet rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } //end try


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
