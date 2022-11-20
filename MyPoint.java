package com.example.csc221_assignment2;

import javafx.scene.canvas.GraphicsContext;

public class MyPoint {

    private double x; //x coordinate
    private double y; //y coordinate
    private MyColor color; //color of the point

    //Default Constructor
    MyPoint()
    {
        this.x = 0;
        this.y = 0;
        this.color = MyColor.BLACK;
    }

    MyPoint(double x, double y, MyColor color)
    {
        setX(x);
        setY(y);
        setColor(color);
    }

    //Copy Constructor
    MyPoint(MyPoint p)
    {
        setPoint(p);
    }

    //Set Methods
    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void setColor(MyColor color)
    {
        this.color = color;
    }

    public void setPoint(MyPoint point)
    {
        this.x = point.getX();
        this.y = point.getY();
        this.color = point.getColor();
    }

    //Get Methods
    public double getX() { return x; }
    public double getY() { return y; }
    public MyColor getColor() { return color; }

    public double getAngle(MyPoint p)
    {
        double dx = p.getX() - x;
        double dy = p.getY() - y;
        return Math.toDegrees(Math.atan(dy / dx));
    }

    //Length Calculation
    public double length(MyPoint p)
    {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    //String Method
    public String toString()
    {
        return "The x coordinate is: " + getX() + " and the y coordinate is: " + getY();
    }

    //Draw Method
    public void draw(GraphicsContext GC)
    {
        GC.setLineWidth(5);
        GC.strokeLine(x, y, x, y);
    }
}
