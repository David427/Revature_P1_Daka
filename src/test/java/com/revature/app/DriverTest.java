package com.revature.app;

import com.revature.annotations.Entity;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class DriverTest {
    @Test
    public static void main(String[] args) throws ClassNotFoundException {
        dakaInit();
    }

    private static void dakaInit() throws ClassNotFoundException {
        Reflections reflections = new Reflections("com.revature");

        //Retrieving all classes with @Entity
        List<Class<?>> entities = new ArrayList(reflections.get(SubTypes.of(TypesAnnotated.with(Entity.class)).asClass()));
        //System.out.println(entities);

        for (Class c : entities) {
            String className = c.getName();

            //Getting the name & constructors of each class in the entities list
            Class<?> clazz = Class.forName(className);
            Constructor[] constructors = clazz.getDeclaredConstructors();
            System.out.println(Arrays.toString(constructors));

            //Retrieving the fields of each class in entities
            List fields = new ArrayList(Arrays.asList(c.getDeclaredFields()));
            //System.out.println(fields.toString());

            //Using Constructor.newInstance() to create objects and eventually fill them with the values of the
            //fields found using reflection.
            //REFERENCE: https://docs.oracle.com/javase/tutorial/reflect/member/ctorInstance.html
            //RESEARCH: Perform reflection only on specific instances of a class?
            Constructor constructor = null;
            for (int i = 0; i < constructors.length; i++) {
                constructor = constructors[i];
                if (constructor.getGenericParameterTypes().length == 0) break;
            }
        }
    }
}
