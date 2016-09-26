package com.jerome.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Rectangle extends Shape {
    double height;
    double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double computeArea() {
        area = height * width;
        return area;
    }
}
