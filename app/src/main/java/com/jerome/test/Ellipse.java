package com.jerome.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Ellipse extends Shape {
    double smallRay;
    double largeRay;

    public Ellipse(double smallRay, double largeRay) {
        this.smallRay = smallRay;
        this.largeRay = largeRay;
    }

    @Override
    public double computeArea() {
        return smallRay * largeRay * Math.PI;
    }
}
