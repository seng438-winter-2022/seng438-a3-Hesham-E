package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class ContainsTest{
	private Range exampleRange; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * Create a range of 0-10 for each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0.0, 10.0);
	}
	
	@Test
	public void testNumbersOutsideLowerBound() {
		Assert.assertFalse("Number is in range and greater than Lower bound", this.exampleRange.contains(-1.00));
	}
	
	@Test
	public void testNumbersOutsideUpperBound() {
		Assert.assertFalse("Number less than upper bound and inside of the range", this.exampleRange.contains(100000.00));
	}
	
	@Test
	public void testNumbersInRange() {
		Assert.assertTrue("Number is out of range", this.exampleRange.contains(6.0));
	}
	
	@Test
	public void testNumberLowerBound() {
		Assert.assertTrue("Lower Bound is out of range", this.exampleRange.contains(0.0));
	}
	
	@Test
	public void testNumberUpperBound() {
		Assert.assertTrue("Upper Bound is out of range", this.exampleRange.contains(10.0));
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
