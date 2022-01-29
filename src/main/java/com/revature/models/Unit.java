package com.revature.models;

import com.revature.annotations.Entity;

public abstract class Unit {
    //region USING REFLECTION TO READ ANNOTATION VALUES
    Class<Unit> unit = Unit.class;
    Entity annotation = unit.getAnnotation(Entity.class);
    //endregion



}

