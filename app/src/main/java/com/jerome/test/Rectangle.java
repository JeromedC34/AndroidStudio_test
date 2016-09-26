package com.jerome.test;

class Rectangle extends Shape {
    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        computeArea();
    }

    @Override
    public double computeArea() {
        area = height * width;
        return area;
    }
}
