package com.mycompany.app;

import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testCounter() {
      ArrayList<String> array1 = new ArrayList<>();
	  array1.add("Ali");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
      
	  String input = "Veli";
	  
	  assertTrue(new App().myMethod(array1, input, 8));
    }

    public void testFalseCounter() {
      ArrayList<String> array1 = new ArrayList<>();
	  array1.add("Ali");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
	  array1.add("Veli");
      
	  String input = "Veli";
	  
	  assertFalse(new App().myMethod(array1, input, 4));
    }

	public void testEmptyList() {
      ArrayList<String> array = new ArrayList<>();
      assertFalse(new App().myMethod(array, "", 0));
    }

    public void testNull() {
      assertFalse(new App().myMethod(null, "", 2));
    }

}
