import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class NearestNeighborTests {

	Random r = new Random();
	Point[] pointArr;
	KDTree kdtree;
	//double epsilon = 0.000001;


	@Test
	public void testNearestNeighborSearch1() 
	{
		buildPointArr(40);
		kdtree = new KDTree(pointArr);
		Point searchPoint = new Point(new double[]{0, 0, 0});
		Point bruteForcePoint = bruteForceNearestNeighbor(searchPoint, pointArr);
		Point kdTreePoint = kdtree.nearestNeighborSearch(searchPoint);
		System.out.println("Test 1");
		System.out.println("     Number Of Points: 40");
		System.out.println("     Search Point: "+searchPoint.toString());
		System.out.println("     Brute Force Result: "+bruteForcePoint.toString());
		System.out.println("     KDTree NN Result:   "+kdTreePoint.toString());
		System.out.println("");
		assertEquals(bruteForcePoint, kdTreePoint);
	}

	@Test
	public void testNearestNeighborSearch2() 
	{
		buildPointArr(500);
		kdtree = new KDTree(pointArr);
		Point searchPoint = new Point(new double[]{0.5, 0.5, 0.5});
		Point bruteForcePoint = bruteForceNearestNeighbor(searchPoint, pointArr);
		Point kdTreePoint = kdtree.nearestNeighborSearch(searchPoint);
		System.out.println("Test 2");
		System.out.println("     Number Of Points: 500");
		System.out.println("     Search Point: "+searchPoint.toString());
		System.out.println("     Brute Force Result: "+bruteForcePoint.toString());
		System.out.println("     KDTree NN Result:   "+kdTreePoint.toString());
		System.out.println("");
		assertEquals(bruteForcePoint, kdTreePoint);
	}

	@Test
	public void testNearestNeighborSearch3() 
	{
		buildPointArr(10000);
		kdtree = new KDTree(pointArr);
		Point searchPoint = new Point(new double[]{0.5, 0.5, 0.5});
		Point bruteForcePoint = bruteForceNearestNeighbor(searchPoint, pointArr);
		Point kdTreePoint = kdtree.nearestNeighborSearch(searchPoint);
		System.out.println("Test 3");
		System.out.println("     Number Of Points: 10000");
		System.out.println("     Search Point: "+searchPoint.toString());
		System.out.println("     Brute Force Result: "+bruteForcePoint.toString());
		System.out.println("     KDTree NN Result:   "+kdTreePoint.toString());
		System.out.println("");
		assertEquals(bruteForcePoint, kdTreePoint);
	}

	@Test
	public void corelDataSetTest()
	{
		CSVReader csvreader = new CSVReader();
		String querySet = "src/covtype_q-1k.csv";
		String resultSet = "src/covtype_qr_out.csv";
		String referenceSet = "src/covtype_r-50k.csv";

		Point[] queryPoints = csvreader.readFileReturnPoints(querySet);
		Point[] dataPoints = csvreader.readFileReturnPoints(referenceSet);
		int[] results = csvreader.readFileReturnInts(resultSet);

		//  for(Point p : queryPoints)
		//  {
		//   System.out.println(p.toString());
		//  }
		//  
		//  for(int i : references)
		//  {
		//   System.out.println(i);
		//  }

		System.out.println("dataPoints.length = "+dataPoints.length);

		kdtree = new KDTree(dataPoints);

		for(int i = 0; i < queryPoints.length; i++)
		{
			assertEquals( dataPoints[results[i]], kdtree.nearestNeighborSearch(queryPoints[i]));
		}
	}

	public void buildPointArr(int numPoints)
	{
		pointArr = new Point[numPoints];
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
		}
	}

	public Point bruteForceNearestNeighbor(Point searchPoint, Point[] pointArr)
	{
		Point nearestNeighbor = pointArr[0];

		for( Point p : pointArr)
		{
			if( searchPoint.distanceTo(p) < searchPoint.distanceTo(nearestNeighbor))
			{
				nearestNeighbor = p;
			}
		}

		return nearestNeighbor;
	}

}
