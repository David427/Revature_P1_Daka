package com.revature.persistence;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks any class that is an Entity, which means it has a mapping to a relational database.
 * Each Entity corresponds to a table in the database, and each instance of an Entity represents one record
 * (row) in that table.
 *
 * @see Table
 * @see Column
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
}
