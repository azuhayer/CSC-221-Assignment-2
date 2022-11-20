package com.example.csc221_assignment2;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {

    private MyPoint pTLC;       //Top left corner of the rectangle
    private double width;          //width of rectangle
    private double height;         //length of rectangle
    private MyColor color;

    //Default Constructor
    MyRectangle()
    {
        super(new MyPoint(), null);
        this.pTLC = new MyPoint();
        this.width = 0;
        this.height = 0;
        this.color = MyColor.BLACK;
    }

    MyRectangle(MyPoint pTLC, double width, double height, MyColor color)
    {
        //super(new MyPoint(), null);

        this.pTLC = pTLC;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //Get Methods
    public MyPoint getTLC() { return pTLC; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public MyColor getColor() { return color; }
    @Override
    public double area() { return width * height; }
    @Override
    public double perimeter() { return 2 * (width + height); }

    //toString Method
    @Override
    public String toString()
    {
        return "Rectangle Top Left Corner " + pTLC + " Width: " + width + " Height: "
                + height + " Perimeter " + perimeter() + " Area "+ area();
    }

    @Override
    public boolean pointInMyShape(MyPoint p)
    {
        //bottom right corner point's coordinates
        double right_cnr_x = pTLC.getX() + width;
        double right_cnr_y = pTLC.getY() + height;

        return (p.getX() >= pTLC.getX()) &&
                (p.getX() <= right_cnr_x) &&
                (p.getY() >= pTLC.getY()) &&
                (p.getY() <= right_cnr_y);
    }

    //Draw Method
    @Override
    public void draw(GraphicsContext GC)
    {
        GC.setFill(color.getColor());
        GC.fillRect(pTLC.getX(), pTLC.getY(), width, height);
    }

    @Override
    public MyRectangle getMyBoundingRectangle()
    {
        return new MyRectangle(pTLC, width, height, MyColor.BLACK);
    }
}
