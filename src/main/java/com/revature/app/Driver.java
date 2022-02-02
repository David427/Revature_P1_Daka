/**
 * Main landing page
 */

package com.revature.app;

import com.revature.annotations.Entity;
import com.revature.annotations.Table;
import com.revature.models.Unit;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

public class Driver {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.revature");

        Set<Class<?>> annotated = reflections.get(SubTypes.of(TypesAnnotated.with(Table.class)).asClass());
        System.out.println(annotated);

        for (Class c : annotated) {
            Class<c> unit = c.class;
            List fields = new ArrayList(c.getDeclaredFields(unit));
        }
    }
}
