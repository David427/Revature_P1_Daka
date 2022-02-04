package com.revature.repositories;

import com.revature.models.TestOne;
import com.revature.persistence.Column;
import com.revature.persistence.Id;
import com.revature.persistence.Table;
import com.revature.util.JdbcConnection;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelRepoImplTest implements ModelRepo {
    Connection conn = JdbcConnection.getConnection();

    @Test
    @Override
    public void addRecord() {

        // Creating an object here only for testing purposes. The real method will have an object passed in.
        Object greatObject = new TestOne(100, "test_title", "test_genre", false);

        Class<?> c = greatObject.getClass();
        Field[] fields = c.getDeclaredFields();
        int len = fields.length;

        //Build column names and ?'s for the sql query
        String cn = ""; //column names
        String id = ""; //id type (default)
        String qm = ""; //question marks

        for (int i = 0; i < len; i++) {
            fields[i].setAccessible(true);
            Column column = fields[i].getAnnotation(Column.class);

            if (fields[i].isAnnotationPresent(Id.class)) {
                Id idField = fields[i].getAnnotation(Id.class);
                id = idField.type();

                try {
                    cn += column.name();

                    if (i < len - 1) {
                        cn += ", ";
                        id += ",";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    cn += column.name();
                    qm += "?";

                    if (i < len - 1) {
                        cn += ", ";
                        qm += ",";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Table table = c.getAnnotation(Table.class);
        String tableName = table.name();

        String sql = "INSERT INTO " + tableName + " (" + cn + ") VALUES (" + id + qm + ")";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i < len; i++) {
                switch (fields[i].getType().toString()) {
                    case "int":
                        ps.setInt((i), fields[i].getInt(greatObject));
                        break;
                    case "long":
                        ps.setLong((i), fields[i].getLong(greatObject));
                        break;
                    case "short":
                        ps.setShort((i), fields[i].getShort(greatObject));
                        break;
                    case "byte":
                        ps.setByte((i), fields[i].getByte(greatObject));
                        break;
                    case "class java.lang.String":
                        ps.setString((i), (String) fields[i].get(greatObject));
                        break;
                    case "boolean":
                        ps.setBoolean((i), fields[i].getBoolean(greatObject));
                        break;
                    case "double":
                        ps.setDouble((i), fields[i].getDouble(greatObject));
                        break;
                    case "float":
                        ps.setFloat((i), fields[i].getFloat(greatObject));
                        break;
                    default:
                        System.out.println("Unsupported: " + fields[i].getType().toString());
                }
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    //region HELPER METHODS
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }
    //endregion
}
