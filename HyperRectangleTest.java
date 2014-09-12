import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * Tests the functionality of the HyperRectangle class.
 * @author Emily Curtin
 *
 */
public class HyperRectangleTest {

	Point[] pointArr;
	HyperRectangle hyperRect;
	double epsilon = 0.000001;

	@Test
	public void testHyperRectangleEdges1d() 
	{
		initPointArr1D();
		hyperRect = new HyperRectangle(pointArr);
		assertEquals(1, hyperRect.getMinOfDimension(0), epsilon);
		assertEquals(100, hyperRect.getMaxOfDimension(0), epsilon);
	}

	@Test
	public void testHyperRectangleEdges3d() 
	{
		initPointArr3D();
		hyperRect = new HyperRectangle(pointArr);
		assertEquals(1, hyperRect.getMinOfDimension(0), epsilon);
		assertEquals(100, hyperRect.getMaxOfDimension(0), epsilon);
		assertEquals(42, hyperRect.getMinOfDimension(1), epsilon);
		assertEquals(141, hyperRect.getMaxOfDimension(1), epsilon);
		assertEquals(-65, hyperRect.getMinOfDimension(2), epsilon);
		assertEquals(34, hyperRect.getMaxOfDimension(2), epsilon);
	}

	@Test
	public void testPointDistance1()
	{
		initRectAndPoints1();
		Point p = new Point(new double[]{-2});
		Point q = new Point(new double[]{0.5});
		Point r = new Point(new double[]{9054});
		assertEquals(2, hyperRect.minimumDistanceFromNearestRectangle(p), epsilon);
		assertEquals(0, hyperRect.minimumDistanceFromNearestRectangle(q), epsilon);
		assertEquals(9053, hyperRect.minimumDistanceFromNearestRectangle(r), epsilon);
	}

	@Test
	public void testPointDistance2()
	{
		initRectAndPoints2();
		Point[] points = new Point[7];
		points[0] = new Point(new double[]{0.5, 0.5});//Distance 0
		points[1] = new Point(new double[]{0, 0.5});//Distance 0
		points[2] = new Point(new double[]{0.5, 0});//Distance 0
		points[3] = new Point(new double[]{0.5, 2});//Distance 1
		points[4] = new Point(new double[]{2, 0.5});//Distance 1
		points[5] = new Point(new double[]{4, 5});//Distance 5
		points[6] = new Point(new double[]{-3, -4});//Distance 5
		assertEquals(0, hyperRect.minimumDistanceFromNearestRectangle(points[0]), epsilon);
		assertEquals(0, hyperRect.minimumDistanceFromNearestRectangle(points[1]), epsilon);
		assertEquals(0, hyperRect.minimumDistanceFromNearestRectangle(points[2]), epsilon);
		assertEquals(1, hyperRect.minimumDistanceFromNearestRectangle(points[3]), epsilon);
		assertEquals(1, hyperRect.minimumDistanceFromNearestRectangle(points[4]), epsilon);
		assertEquals(5, hyperRect.minimumDistanceFromNearestRectangle(points[5]), epsilon);
		assertEquals(5, hyperRect.minimumDistanceFromNearestRectangle(points[6]), epsilon);
	}


	@After
	public void cleanUp()
	{
		pointArr = null;
		hyperRect = null;
	}

	public void initPointArr1D()
	{
		pointArr = new Point[100];
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{i+1});
		}
	}

	public void initPointArr3D()
	{
		pointArr = new Point[100];
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{i+1, i+42, i-65});
		}
	}

	public void initRectAndPoints1()
	{
		pointArr = new Point[2];
		pointArr[0] = new Point(new double[]{0});
		pointArr[1] = new Point(new double[]{1});
		hyperRect = new HyperRectangle(pointArr);
	}

	public void initRectAndPoints2()
	{
		pointArr = new Point[2];
		pointArr[0] = new Point(new double[]{0, 0});
		pointArr[1] = new Point(new double[]{1, 1});
		hyperRect = new HyperRectangle(pointArr);
	}
}
