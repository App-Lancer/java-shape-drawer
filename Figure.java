import java.awt.Color;

public class Figure{
    public static void main(String args[]){

        ShapeDrawer drawer = new ShapeDrawer(1800, 1800);

        Point[] points = new Point[5];
        points[0] = new Point(100, 300);
        points[1] = new Point(500, 700);
        points[2] = new Point(400, 1500);
        points[3] = new Point(700, 600);
        points[4] = new Point(900, 1000);

        Polygon poly = new Polygon(points);

        poly.move(100, 200);
        poly.rotateAroundCenter(90);
        drawer.setFill(Color.RED);
        drawer.setStroke(Color.RED);
        drawer.draw(poly);
        drawer.writeToFile("image.png");
        

    }
}