package com.example.csc221_assignment2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;
import java.util.List;

public interface MyShapeInterface {

    public abstract MyRectangle getMyBoundingRectangle();
    public abstract boolean pointInMyShape(MyPoint p);
    public static MyRectangle overlapMyShapes(MyShape S1, MyShape S2) {

        MyRectangle bound1 = S1.getMyBoundingRectangle();
        MyRectangle bound2 = S2.getMyBoundingRectangle();

        //Properties of bounding rectangle of S1
        double x1 = bound1.getTLC().getX();
        double y1 = bound1.getTLC().getY();
        double w1 = bound1.getWidth();
        double h1 = bound1.getHeight();

        //Properties of bounding rectangle of S2
        double x2 = bound2.getTLC().getX();
        double y2 = bound2.getTLC().getY();
        double w2 = bound2.getWidth();
        double h2 = bound2.getHeight();

        if (y1 + h1 < y2 || y2 + h2 < y1) {
            return null;
        }

        if (x1 + w1 < x2 || x2 + w2 < x1) {
            return null;
        }

        double x_min = Math.min(x1 + w1, x2 + w2);
        double x_max = Math.max(x1, x2);
        double y_min = Math.min(y1 + h1, y2 + h2);
        double y_max = Math.max(y1, y2);

        MyPoint bound_point = new MyPoint(x_max, y_max, null);
        return new MyRectangle(bound_point, Math.abs(x_min - x_max), Math.abs(y_min - y_max), null);
    }
    public static List<MyPoint> intersectMyShapes(MyShape S1, MyShape S2) {

        MyRectangle overlap = overlapMyShapes(S1, S2);

        if (overlap != null) {
            double x = overlap.getTLC().getX();
            double y = overlap.getTLC().getY();
            double w = overlap.getWidth();
            double h = overlap.getHeight();

            List<MyPoint> intersect = new ArrayList<>();

            for (int i = 0; i < w; i++)
            {
                double xi = x + i;
                for (int j = 0; j < h; j++)
                {
                    MyPoint p = new MyPoint(xi, y + j, MyColor.BLACK);
                    if (S1.pointInMyShape(p) && S2.pointInMyShape(p))
                    {
                        intersect.add(p);
                    }
                }
            }
            return intersect;
        }
        else
        {
            return null;
        }
    }
    public default Canvas drawIntersectMyShapes(MyShape S1, MyShape S2, double w, double h)
    {
        List<MyPoint> intersect = intersectMyShapes(S1, S2);
        Canvas overlayCV = new Canvas(w, h);
        GraphicsContext overlayGC = overlayCV.getGraphicsContext2D();

        S1.draw(overlayGC);
        S2.draw(overlayGC);

        for (MyPoint p : intersect)
        {
            p.draw(overlayGC);
        }
        return overlayCV;
    }
}
