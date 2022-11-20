package com.example.csc221_assignment2;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {

    double height;
    double width;
    MyPoint center;
    MyColor color;
    double semiMajor;
    double semiMinor;

    //default constructor
    MyOval()
    {
        super(new MyPoint(), null);

        this.height = 0;
        this.width = 0;
        this.center = new MyPoint();
        this.semiMajor = 0;
        this.semiMinor = 0;
        this.color = MyColor.BLACK;
    }

    //Constructor with parameters
    MyOval(double height, double width, MyPoint center, MyColor color)
    {
        super(new MyPoint(), color);

        this.height = height;
        this.width = width;
        this.center = center;
        this.color = color;
        this.semiMinor = (width < height) ? width : height;
        this.semiMajor = (width > height) ? width : height;
    }

    //Get Methods
    public MyPoint getCenter() { return center; }
    public double getMinorAxis() { return semiMinor; }
    public double getMajorAxis() { return semiMajor; }
    public MyColor getColor () { return color; }

    //Methods for Perimeter and Area
    @Override
    public double area() { return (Math.PI * (height / 2) * (width / 2)); }
    @Override
    public double perimeter() { return ((2 * Math.PI) * Math.sqrt((height * height + width * width) / 2)); }

    //Bounding rectangle of a MyOval Object
    public MyRectangle getMyBoundingRectangle()
    {
        double x = center.getX() - width;
        double y = center.getY() - height;
        MyPoint pLTC = new MyPoint(x, y, null);

        return new MyRectangle(pLTC, 2 * width, 2 * height, null);
    }

    public boolean pointInMyShape(MyPoint p)
    {
        if (width == height)
        {
            return center.length(p) <= width;
        }
        else
        {
            double dx = center.getX() - p.getX();
            double dy = center.getY() - p.getY();

            return Math.pow(height * dx, 2) + Math.pow(width * dy, 2) <= Math.pow(width * height, 2);
        }
    }

    public boolean similarObject(MyShape S)
    {
        if (S.getClass().toString().equals("clas MyOval"))
        {
            MyOval O = (MyOval) S;
            return (this.semiMajor == O.getMajorAxis() && this.semiMinor == O.getMinorAxis());
        }
        else
        {
            return false;
        }
    }

    //Print Method
    @Override
    public String toString()
    {
        return 	"Semi Minor Length: " + semiMinor + "\n" +
                "Semi Major Length: " + semiMajor + "\n" +
                "Perimeter: " + perimeter() + "\n" +
                "Area: " + area() + "\n" +
                "Center: (" + center.getX() + ", " + center.getY() + ")" + "\n";
    }

    //Draw Method
    @Override
    public void draw (GraphicsContext GC)
    {
        GC.setFill(color.getColor());
        GC.fillOval(center.getX() - width , center.getY() - height, 2 * width, 2 * height);
    }
}

