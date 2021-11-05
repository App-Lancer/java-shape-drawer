public class Point{
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }

    public void rotateAroundOrigin(double theta){
        double radianValue = Math.toRadians(theta);

        //System.out.println("X value : " + ((x * Math.cos(radianValue)) - (y * Math.sin(radianValue))));

        //System.out.println("Y Value : " + ((y * Math.cos(radianValue)) + (x * Math.sin(radianValue))));

        double x1 = ((x * Math.cos(radianValue)) - (y * Math.sin(radianValue)));
        double y1 = ((y * Math.cos(radianValue)) + (x * Math.sin(radianValue)));

        this.x = x1;
        this.y = y1;
    }

    public String toString(){
        return "("+ this.x +", "+ this.y +")";
    }

    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
    }
}