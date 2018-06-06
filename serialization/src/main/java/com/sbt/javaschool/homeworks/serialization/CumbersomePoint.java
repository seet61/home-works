package com.sbt.javaschool.homeworks.serialization;

/**
 * Class for serialization
 */
public class CumbersomePoint {
    private String name;
    private double x;
    private double y;

    CumbersomePoint(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    CumbersomePoint() {
        System.out.println("no-arg constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "CumbersomePoint{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
