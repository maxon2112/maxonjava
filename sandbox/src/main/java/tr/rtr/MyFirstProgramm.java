package tr.rtr;



public class MyFirstProgramm {
    public static void main(String[] args) {


    Point p1 = new Point(5, 5);
    Point p2 = new Point(10, 10);

        System.out.println("Расстояние между двумя точками p1("+p1.x +","+ p1.y+") и p2("+p2.x +","+ p2.y+")="+p1.distance(p2));

}
}


