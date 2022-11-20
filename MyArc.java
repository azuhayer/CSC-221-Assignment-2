package com.example.csc221_assignment2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class MyArc extends MyShape {

    double startAngle;
    double angle;
    double rStartAngle;
    double rAngle;
    double rEndAngle;
    MyPoint p1, p2;
    MyPoint center;
    MyCircle circle;
    double radius;
    MyColor color;

    //Constructor with point parameters
    MyArc(MyCircle circle, MyPoint p1, MyPoint p2, MyColor c)
    {
        super(new MyPoint(), c);

        this.color = c;
        this.circle = circle;
        this.center = circle.getCenter();
        this.radius = circle.getRadius();

        this.p1 = p1;
        this.p2 = p2;

        this.startAngle = center.getAngle(p1);
        this.angle = center.getAngle(p2) - startAngle;

        this.rStartAngle = Math.toRadians(startAngle);
        this.rAngle = Math.toRadians(angle);
        this.rEndAngle = Math.toRadians(startAngle + angle);
    }

    //Constructor with angle parameters
    MyArc(MyCircle circle, double startAngle, double angle, MyColor c)
    {
        super(new MyPoint(), c);

        this.color = c;
        this.circle = circle;
        this.center = circle.getCenter();
        this.radius = circle.getRadius();

        this.startAngle = startAngle;
        this.angle = angle;

        this.rStartAngle = Math.toRadians(startAngle);
        this.rAngle = Math.toRadians(angle);
        this.rEndAngle = Math.toRadians(startAngle + angle);

        double x1 = center.getX() + radius * Math.cos(-rStartAngle);
        double y1 = center.getY() + radius * Math.sin(-rStartAngle);

        double x2 = center.getX() + radius * Math.cos(-rEndAngle);
        double y2 = center.getY() + radius * Math.sin(-rEndAngle);

        this.p1 = new MyPoint(x1, y1, MyColor.BLACK);
        this.p2 = new MyPoint(x2, y2, MyColor.BLACK);
    }

    //Get Methods
    public MyPoint getCenter() { return center; }
    public double getRadius() { return radius; }
    public double getStartAngle() { return startAngle; }
    public double getAngle() { return angle; }
    public MyPoint getP1() { return p1; }
    public MyPoint getP2() { return p2; }

    //Area
    @Override
    public double area()
    {

        return (Math.pow(radius, 2) * Math.toRadians(angle)) / 2;
    }

    //Perimeter
    @Override
    public double perimeter()
    {
        return radius * Math.toRadians(angle);
    }

    //toString Method
    public String toString()
    {
        return "This is an object of the MyArc class. Its center point is " +
                getCenter() + " Its radius is " + getRadius() + "It starts at an angle of " + getStartAngle() +
                " degrees and open for " + getAngle() + " degrees";
    }

    //Draw function
    @Override
    public void draw(GraphicsContext gc)
    {
        gc.setFill(color.getColor());
        gc.fillArc(getCenter().getX() - radius, getCenter().getY() - radius, radius * 2, radius *
                2, startAngle, angle, ArcType.ROUND);
    }

    @Override
    public MyRectangle getMyBoundingRectangle()
    {
        return circle.getMyBoundingRectangle();
    }

    @Override
    public boolean pointInMyShape(MyPoint p)
    {
        double pAngle = Math.toRadians(center.getAngle(p));
        return (rStartAngle <= pAngle && pAngle <= rEndAngle);
    }

}
