package com.revature.app;

import com.revature.models.TestOne;
import com.revature.persistence.Entity;
import com.revature.repositories.MappableImpl;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class DriverTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //dakaInit();
        TestOne t = new TestOne();
        MappableImpl m = new MappableImpl();
        m.add(t);
    }

    @Test
    private static void dakaInit() throws ClassNotFoundException {
        Reflections reflections = new Reflections("com.revature");

        //Retrieving all classes with @Entity
        List<Class<?>> entities = new ArrayList(reflections.get(SubTypes.of(TypesAnnotated.with(Entity.class)).asClass()));
        assertTrue(Arrays.asList("Entity.class").containsAll(entities));

        for (Class c : entities) {

            //Getting the name & constructors of each class in the entities list
            String className = c.getName();
            Class<?> clazz = Class.forName(className);

            Constructor[] constructors = clazz.getDeclaredConstructors();
            //System.out.println(Arrays.toString(constructors));

            //Retrieving the fields of each class in entities
            List fields = new ArrayList(Arrays.asList(c.getDeclaredFields()));
            //System.out.println(fields.toString());

            //Using Constructor.newInstance() to create objects and eventually fill them with the values of the
            //fields found using reflection.
            //REFERENCE: https://docs.oracle.com/javase/tutorial/reflect/member/ctorInstance.html
            Constructor constructor = null;

            for (int i = 0; i < constructors.length; i++) {
                constructor = constructors[i];
                if (constructor.getGenericParameterTypes().length == 0) break;
            }

            try {
                constructor.setAccessible(true);
                Object test = constructor.newInstance();
                Field f = test.getClass().getDeclaredField("id");
                f.setAccessible(true);
                System.out.println(f);
            } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    //@Test
    //public Object dakaSave(Object o) {
    //    Class clazz = o.getClass();
    //
    //    assertEquals("TestOne", clazz.getSimpleName());
    //    return null;
    //}
}
