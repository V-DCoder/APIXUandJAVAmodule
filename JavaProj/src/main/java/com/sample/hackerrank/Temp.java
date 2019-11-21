package com.sample.hackerrank;

public class Temp {

    public static void main(String args[])
    {

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.getShape("Rectangle");
        Shape circle = shapeFactory.getShape("circle");
        Shape square = shapeFactory.getShape("square");


        rectangle.setParam(2,3);

        rectangle.getArea();

        for(int i=2;i==5;i++)
        {

        }



    }
}
