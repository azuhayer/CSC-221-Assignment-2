import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Assignment2 extends Application {

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("CSC 221 Assignment 2 By Zuhayer Alvi");

        double height = 700;
        double width = 700;

        //radius of circle
        double radius = 200;

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        //Point declarations
        MyPoint center = new MyPoint(width / 2, height / 2, MyColor.BLACK);
        MyPoint rp1 = new MyPoint(45, 45, MyColor.BLACK);

        //Circle Declaration
        MyCircle c1 = new MyCircle(center, radius, null);

        //Arc Declarations
        MyArc a1 = new MyArc(c1, 0, 45, MyColor.CYAN);
        MyArc a2 = new MyArc(c1, 45, 70, MyColor.FUCHSIA);
        MyArc a3 = new MyArc(c1, 115, 55, MyColor.MAGENTA);
        MyArc a4 = new MyArc(c1, 170, 100, MyColor.SLIGHTLYDESATURATEDCYAN);
        MyArc a5 = new MyArc(c1, 270, 90, MyColor.VERYSOFTCYAN);

        //Draw the shapes onto canvas
        c1.draw(gc);
        a1.draw(gc);
        a2.draw(gc);
        a3.draw(gc);
        a4.draw(gc);
        a5.draw(gc);

    }

    public static void main(String[] args)
    {
        launch();
    }
}

/*public class Assignment2 extends Application {

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Bounding Rectangle of an Arc");

        double height = 700;
        double width = 700;

        //radius of circle
        double radius = 200;

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        //Point Declaration
        MyPoint center = new MyPoint(width/2, height/2, MyColor.BLACK);

        //Circle Declaration
        MyCircle c1 = new MyCircle(center, radius, MyColor.WHITE);

        //MyArc Declaration
        MyArc a1 = new MyArc(c1, 0, 45, MyColor.CYAN);

        //Bounding rectangle declaration
        MyRectangle bound = a1.getMyBoundingRectangle();

        //draw
        bound.draw(gc);
        a1.draw(gc);
    }

    public static void main(String[] args)
    {
        launch();
    }
}*/

/*public class Assignment2 extends Application {

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Intersection of Two Rectangle Objects");

        double height = 700;
        double width = 700;

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        //MyPoint Declarations
        MyPoint p1 = new MyPoint(200, 200, MyColor.BLACK);
        MyPoint p2 = new MyPoint(200, 200, MyColor.BLACK);

        //MyRectangle Declarations
        MyRectangle r1 = new MyRectangle(p1, 200, 100, MyColor.FUCHSIA);
        MyRectangle r2 = new MyRectangle(p2, 100, 200, MyColor.CYAN);

        //Draw the Intersection
        root.getChildren().add(r1.drawIntersectMyShapes(r1, r2, height, width));

    }

    public static void main(String[] args)
    {
        launch();
    }
}*/

/*public class Assignment2 extends Application {

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Intersection of Rectangle Object and Circle Object");

        double height = 700;
        double width = 700;

        double ch = 200;
        double cw = 200;

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        //MyPoint Declarations
        MyPoint p1 = new MyPoint(150, 150, MyColor.BLACK);
        MyPoint p2 = new MyPoint(width / 2, height / 2, MyColor.BLACK);

        //MyRectangle Declarations
        MyRectangle r1 = new MyRectangle(p1, 400, 300, MyColor.FUCHSIA);

        //MyCircle Declaration
        MyOval c1 = new MyOval(ch, cw, p2, MyColor.CYAN);

        //Draw the intersection
        root.getChildren().add(r1.drawIntersectMyShapes(r1, c1, width, height));

    }

    public static void main(String[] args)
    {
        launch();
    }
}*/
