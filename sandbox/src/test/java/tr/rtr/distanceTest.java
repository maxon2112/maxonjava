package tr.rtr;


//import org.testng.Assert;
import org.testng.annotations.Test;

public class distanceTest {
    @Test
    public void TestArea(){
        Point p1 =new Point(5,5);
        Point p2=new Point(10,10);
        assert p1.distance(p2)==7.0710678118654755;
    }

}
