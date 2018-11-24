package tr.rtr;

public class Point {
    public double x;
    public double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(double x, double y) {
        double xx = this.x - x;
        double yy = this.y - y;
        return Math.sqrt(Math.pow((xx), 2) + Math.pow((yy), 2));
    }

    double distance(Point d) {

        return distance(d.x, d.y);
        }
    }



