package com.sample.hackerrank;

public class ShapeFactory {

    public Shape getShape(String type) {

        if ("Circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("Rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        }else {
            return new Square();
        }
    }
}
