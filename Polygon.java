public class Polygon{

    private Point[] points;

    public Polygon(Point[] points){
        this.points = points;
    }

    public int getNumPoints(){
        return this.points.length;
    }

    public Point getPoint(int index){
        if(index < this.points.length && index >=0){
            return this.points[index];
        }

        return null;
    }

    public Point getCenter(){
        double xSum =0, ySum = 0;

        for(int i=0; i< this.points.length; i++){
            Point temp = this.points[i];
            xSum += temp.getX();
            ySum += temp.getY();
        }

        double avgX = xSum / this.points.length;
        double avgY = ySum / this.points.length;

        return new Point(avgX, avgY);
    }

    public double getPerimeter(){

        double perimeter = 0;

        for(int i=0; i< this.points.length -1; i++){
            perimeter += Point.distance(this.points[i], this.points[i + 1]);
        }

        perimeter += Point.distance(this.points[this.points.length - 1], this.points[0]);

        return perimeter;
    }

    public String toString(){
        String returnValue = "";

        for(int i=0; i< this.points.length; i++){
            returnValue += "("+ this.points[i].getX() +", "+ this.points[i].getY() +")";

            if(i != this.points.length - 1){
                returnValue += " -- ";
            }
        }

        return returnValue;
    }

    public void move(double dx, double dy){
        for(int i=0; i<this.points.length; i++){
            this.points[i].move(dx, dy);
        }
    }

    public Point getTopLeft(){
        double lowX = Double.MAX_VALUE, lowY = Double.MAX_VALUE;

        for(int i=0; i<this.points.length; i++){
            Point temp = this.points[i];

            if(lowX > temp.getX()){
                lowX = temp.getX();
            }

            if(lowY > temp.getY()){
                lowY = temp.getY();
            }
        }

        return new Point(lowX, lowY);
    }

    public Point getBottomRight(){
        double maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;

        for(int i=0; i< this.points.length; i++){
            Point temp = this.points[i];

            if(maxX < temp.getX()){
                maxX = temp.getX();
            }

            if(maxY < temp.getY()){
                maxY = temp.getY();
            }
        }

        return new Point(maxX, maxY);
    }

    public void rotateAroundCenter(double theta){

        Point center = getCenter();

        for(int i=0; i<this.points.length; i++){

            Point temp = this.points[i];
            Point secondTemp = new Point(temp.getX() - center.getX(), temp.getY() - center.getY());
            secondTemp.rotateAroundOrigin(theta);

            this.points[i] = new Point(secondTemp.getX() + center.getX(), secondTemp.getY() + center.getY());
        }
    }
}