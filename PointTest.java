import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


public class PointTest {

 Point a;
 Point b;
 double epsilon = 0.000001;
 
 @Test
 public void testOneDDistance() 
 {
  oneDPoints();
  assertEquals(4, a.distanceTo(b), epsilon);
 }
 
 @Test
 public void testTwoDDistance() 
 {
  twoDPoints();
  assertEquals(5, a.distanceTo(b), epsilon);
 }
 
 @Test
 public void testThreeDDistance() 
 {
  threeDPoints();
  assertEquals(203.061567, a.distanceTo(b), epsilon);
 }
 
 @Test
 public void testFourDDistance() 
 {
  fourDPoints();
  assertEquals(8998.291505, a.distanceTo(b), epsilon);
 }
 
 
 
 @After
 public void cleanUp()
 {
  a = null;
  b = null;
 }
 
 public void oneDPoints()
 {
  //Distance = 4
  a = new Point(new double[]{1});
  b = new Point(new double[]{5});
 }
 
 public void twoDPoints()
 {
  //Distance = 5
  a = new Point(new double[]{1, 2});
  b = new Point(new double[]{5, 5});
 }
 
 public void threeDPoints()
 {
  //Distance = 203.061567
  a = new Point(new double[]{1, 2, 3});
  b = new Point(new double[]{5, 5, -200});
 }
 
 public void fourDPoints()
 {
  //Distance = 8998.291505
  a = new Point(new double[]{1, 2, 3, 4});
  b = new Point(new double[]{5, 5, -200, 9000});
 }

}
