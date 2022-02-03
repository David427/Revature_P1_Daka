package com.revature.app;

import com.revature.models.TestOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

class AddTest {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void dakaAdd() throws NoSuchMethodException {
        //Creating an object only for testing purposes. The real method will have an object passed in.
        Object greatObject = new TestOne();

        Class<?> clazz = greatObject.getClass();
        assertEquals("com.revature.models.TestOne", clazz.getName());

        Field[] fieldz = clazz.getDeclaredFields();
        List<String> fieldzList = getFieldNames(fieldz);
        System.out.println(fieldzList);
        assertTrue(Arrays.asList("id", "title", "genre", "onFire").containsAll(fieldzList));

        Method[] methodz = clazz.getDeclaredMethods();
        List<String> methodzList = getMethodNames(methodz);
        System.out.println(methodzList);
        List<String> expectedMethodNames = Arrays.asList("getId", "setGenre", "isOnFire", "getTitle",
                "setOnFire", "setId", "setTitle", "getGenre");
        assertEquals(expectedMethodNames.size(), methodzList.size());
        assertTrue(expectedMethodNames.containsAll(methodzList));
        assertTrue(methodzList.containsAll(expectedMethodNames));

        //For each field, get and then invoke the corresponding getter.
        //TODO: HOW TO KNOW WHICH GETTER TO INVOKE?!?! WHERE IS IT IN THE COLLECTION?!?!?!
        for (String f : fieldzList) {
            Method test = clazz.getDeclaredMethod(methodzList.get(1));
        }

    }

    //HELPER METHOD
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

    //HELPER METHOD
    private static List<String> getMethodNames(Method[] methods) {
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods)
            methodNames.add(method.getName());
        return methodNames;
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
