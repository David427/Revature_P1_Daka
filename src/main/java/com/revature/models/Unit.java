package com.revature.models;

import com.revature.annotations.Entity;
import com.revature.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Table
public abstract class Unit {

    //region USING REFLECTION TO GET ALL CLASSES WITH @ENTITY
    //May need https://mvnrepository.com/artifact/org.reflections/reflections/0.10.2
    //David sent an email asking Ryan if our library, which is meant to be used as a dependency for the web app,
    //can have dependencies of its own. Will Maven load both Daka and the Reflections dependency that it needs
    //to work? Probably... but I want to make sure.
    //endregion

    ////region USING REFLECTION TO READ ANNOTATION VALUES
    Class<Unit> unit = Unit.class;
    Entity annotation = unit.getAnnotation(Entity.class);
    //endregion



}

