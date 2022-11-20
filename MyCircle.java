package com.example.csc221_assignment2;

public class MyCircle extends MyOval {

    MyPoint center;
    double radius;
    MyColor color;

    //Constructor
    MyCircle(MyPoint p, double r, MyColor color)
    {
        super(r, r, p, MyColor.BLACK);
        this.center = p;
        this.radius = r;
        this.color = color;
    }

    //Get Methods
    public MyPoint getCenter() { return center; }
    public double getRadius() { return radius; }
    public MyColor getColor() { return color; }

    @Override
    public boolean similarObject(MyShape S)
    {
        if(S.getClass().toString().equals("class MyCircle"))
        {
            MyCircle C = (MyCircle) S;
            return (this.radius == C.getRadius());
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "Circle center: (" + center.getX() + ", " + center.getY() + ")" + "\n" +
                "Radius: " + radius + "\n" +
                "Perimeter: " + perimeter() + "\n" +
                "Area: " + area();
    }

}
