import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.Arrays;

public class ArraySortJTest
{
  Random numGen= new Random();
  
  int MaxSize= 500;
  
  int TestsNum=500;
    
  public static void main(String args[])
  {
    org.junit.runner.JUnitCore.main("ArraySortJTest");
  }
  
  //create a random array of random length <= MaxSize
  private int[] arrayGenerator()
  {
    int r= numGen.nextInt(MaxSize+1);
    int[] tArray= new int[r];
    for(int x=0;x<r;x++)
    {
      int t=numGen.nextInt();
      tArray[x]=r;
    }
    
    return tArray;
  }
  
  //Test to ensure that output array is the same size as the input array
  @Test
  public void testSize()
  {
    for(int x=0;x<TestsNum;x++)
    {
      int [] originalArray= arrayGenerator();
      int [] copyArray= Arrays.copyOf(originalArray, originalArray.length);
      
      Arrays.sort(originalArray);
      
      assertEquals(originalArray.length, copyArray.length);
      
    }
  }
  
  //tests that output array values are always increasing or staying the same
  @Test
  public void testIncreasing()
  {
    for(int x=0; x<TestsNum; x++)
    {
      int [] array=arrayGenerator();
      Arrays.sort(array);
      
      for(int y=1;y<array.length;y++)
      {
        assertTrue(array[y]>=array[y-1]);
      }
    }
  }
  
  //Tests that the values in output array are never decreasing
  @Test
  public void testNeverDecreasing()
  {
    for(int x=0; x<TestsNum; x++)
    {
      int [] array=arrayGenerator();
      Arrays.sort(array);
      
      for(int y=1;y<array.length;y++)
      {
        assertFalse(array[y]<array[y-1]);
      }
    }
  }
  
  //Tests that running the sort again will not change output (Idempotent)
  @Test
  public void testIdempotent()
  {
    for(int x=0; x<TestsNum; x++)
    {
      int [] array=arrayGenerator();
      Arrays.sort(array);
      
      int [] copyArray= Arrays.copyOf(array,array.length);
      Arrays.sort(array);
      assertArrayEquals(array, copyArray);
    }
  }
  
  //Tests that running sort on the same input twice yields same output twice (pure)
  @Test
  public void testPure()
  {
    for(int x=0; x<TestsNum; x++)
    {
      int [] array=arrayGenerator();
      int [] copyArray= Arrays.copyOf(array,array.length);
      Arrays.sort(array);
      Arrays.sort(copyArray);
      
      assertArrayEquals(array, copyArray);
    }
  }
  
}