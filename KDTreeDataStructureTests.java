import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Test;


public class KDTreeDataStructureTests {

	KDTree kdtree;
	Point[] pointArr;

	@After
	public void cleanUp()
	{
		kdtree = null;
		pointArr = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void checkForBoundOverlap()
	{
		pointArr = new Point[40];
		Random r = new Random();
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
		}

		kdtree = new KDTree(pointArr);

		kdtree.overlapCheck();
	}


	@Test
	public void checkForPointContainment()
	{
		pointArr = new Point[40];
		Random r = new Random();
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
		}

		kdtree = new KDTree(pointArr);
		kdtree.inOrderForPointContainmentCheck();

	}

	@Test
	public void checkForDuplicates()
	{
		pointArr = new Point[40];
		Random r = new Random();
		for(int i = 0; i < pointArr.length; i++)
		{
			pointArr[i] = new Point(new double[]{r.nextDouble(), r.nextDouble(), r.nextDouble()});
		}

		//  System.out.println("Original pointArr");
		//  for(Point p : pointArr)
		//  {
		//   System.out.println(p.toString());
		//  }

		kdtree = new KDTree(pointArr);
		ArrayList<Point> checkForDuplicates = kdtree.inOrder();

		boolean wereThereDuplicates = false;

		//Doing this the O(n^2) way to ensure correctness
		for(int i =  0; i < checkForDuplicates.size(); i++)
		{
			for(int j = 0; j < checkForDuplicates.size(); j++)
			{
				if(checkForDuplicates.get(i).equals(checkForDuplicates.get(j)) && i != j)
				{
					wereThereDuplicates = true;
					System.out.println("Duplicate Points Found: Indices i = "+i+" and j = "+j);
					System.out.println("     Point at "+i+": "+checkForDuplicates.get(i).toString());
					System.out.println("     Point at "+j+": "+checkForDuplicates.get(j).toString());
				}
			}
		}
		assertFalse(wereThereDuplicates);
	}
}
