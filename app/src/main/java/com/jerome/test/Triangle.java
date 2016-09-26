package com.jerome.test;

class Triangle extends Shape {
    private double height;
    private double base;

    Triangle(double height, double base) {
        this.height = height;
        this.base = base;
        computeArea();
    }

    @Override
    public double computeArea() {
        area = (height * base) / 2;
        return area;
    }
}
