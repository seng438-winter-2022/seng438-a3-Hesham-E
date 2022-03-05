package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test; 
import org.junit.*;

public class EqualsTest {

	private Range range;
	
	@Before
	public void setUp() throws Exception {
		range = new Range(0.0, 5.0);        //setting the range
	}
	
	@Test
	public void NotInRange() {
		assertEquals(false, range.equals("abcdefg")); // checking if set of characters equal the range
	}
	
	@Test
	public void DifferentRange() {
		assertEquals(false, range.equals(new Range(1.0, 3.0)));  //testing whether two different range objects with different ranges are equal
	}
	

	@Test
	public void AnotherRange() {
		assertEquals(true, range.equals(new Range(0.0, 5.0)));   //testing whether two different range objects with same ranges are equal
	}
	
	@Test
	public void SameRange() {
		assertEquals(true, range.equals(range));  //testing using same range object
	}
	
	@Test
	public void LowerBound() {
		assertEquals(false, range.equals(new Range(1.0, 5.0)));   
	}
	
	@Test
	public void UpperBound() {
		assertEquals(false, range.equals(new Range(0.0, 4.0)));
  }
}
