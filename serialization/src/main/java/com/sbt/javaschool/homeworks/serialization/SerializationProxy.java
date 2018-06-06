package com.sbt.javaschool.homeworks.serialization;

import java.io.Serializable;

public class SerializationProxy implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private double x;
    private double y;

    public SerializationProxy(ConvenientPoint point) {
        this.name = point.getName();
        this.x = point.getX();
        this.y = point.getY();
    }

    private Object readResolve() {
        return new ConvenientPoint(name, x, y);
    }
}
