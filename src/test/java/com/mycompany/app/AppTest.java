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
      ArrayList<String> array1 = new ArrayList<>(Arrays.asList("Ali", "Veli"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("Burak","Alp"));
	  assertTrue(new App().myMethod(array1, 4, array2));
    }

    public void testFalseCounter() {
      ArrayList<String> array1 = new ArrayList<>(Arrays.asList("Ali", "Veli"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("Burak","Alp"));
	  assertTrue(new App().myMethod(array1, 6, array2));
    }

    public void testEmptyList() {
      ArrayList<String> array = new ArrayList<>();
      assertFalse(new App().search(array, 0, array));
    }

    public void testNull() {
      assertFalse(new App().search(null, 0, null));
    }

}
