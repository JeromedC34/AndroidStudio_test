package com.jerome.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Triangle extends Shape {
    double height;
    double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double computeArea() {
        return (height * base) / 2;
    }

}
