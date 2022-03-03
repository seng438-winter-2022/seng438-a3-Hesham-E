package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class shift1Test {
//shift(Range,double)
	
private static Range test;
	
	@BeforeClass
	public static void setup() {
		test= new Range(-10,10);
	}

	@Test
	public void testShiftNegativeBy5() {
		Range expected = new Range(-15, 5);
		assertEquals(expected, Range.shift(test, -5));
	}
	
	@Test
	public void testShiftNegativeBy20() {
		Range expected = new Range(-30, 0);
		assertEquals(expected, Range.shift(test, -20));
	}
	@Test
	public void testShiftPositiveBy5() {
		Range expected = new Range(-5, 30);
		assertEquals(expected, Range.shift(test, 5));
	}
	
	@Test
	public void testShiftPositiveBy20() {
		Range expected = new Range(0, 30);
		assertEquals(expected, Range.shift(test, 20));
	}
	@Test
	public void testShiftPositiveBy10() {
		Range expected= new Range(0,40);
		assertEquals(expected, Range.shift(test, 40));
	}
	@Test
	public void testShiftNegativeBy10() {
		
	}
	@Test
	public void testNull() {
		boolean thrown =false;
		try {
			Range.shift(null, 0);
		}catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testShiftbyNaN() {
		Range actual = Range.shift(test, Double.NaN);
		Double upper = actual.getUpperBound();
		Double lower = actual.getLowerBound();
		boolean NaNCheck=true;
		if(Double.compare(Double.NaN, upper)!=0) {
			NaNCheck=false;
		}
		if(Double.compare(Double.NaN, lower)!=0) {
			NaNCheck=false;
		}
		assertTrue(NaNCheck);
	}
	
	@Test
	public void testShiftByNegativeInf() {
		Range expected = new Range(Double.NEGATIVE_INFINITY, 0);
		assertEquals(expected, Range.shift(test, Double.NEGATIVE_INFINITY));
	}
	@Test
	public void testShiftByPositiveInf() {
		Range expected = new Range(0, Double.POSITIVE_INFINITY);
		assertEquals(expected, Range.shift(test, Double.POSITIVE_INFINITY));
	}

}
