package com.jerome.test;

class Ellipse extends Shape {
    private double smallRay;
    private double largeRay;

    Ellipse(double smallRay, double largeRay) {
        this.smallRay = smallRay;
        this.largeRay = largeRay;
        computeArea();
    }

    @Override
    public double computeArea() {
        area = smallRay * largeRay * Math.PI;
        return area;
    }
}
