package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesEqualTest {
	private Mockery mocking;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mocking = new Mockery();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void TwoEqual() {
		double[][] a = {{1, 2}, {3, 4}};
		double[][] b = {{1, 2}, {3, 4}};
		
		assertTrue(DataUtilities.equal(a, b));
	}
	
	@Test
	public void DifferentLengths() {
		double[][] a = {{1, 2}, {3, 4}};
		double[][] b = {{1, 2}};
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void TwoNotEqual() {
		double[][] a = {{1, 2}, {3, 4}};
		double[][] b = {{1, 2}, {3, 5}};
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void TwoNull() {
		assertTrue(DataUtilities.equal(null, null));
	}
	
	@Test
	public void IsNullA() {
		double[][] b = {{1, 2}};
		
		assertFalse(DataUtilities.equal(null, b));
	}
	
	@Test
	public void IsNullB() {
		double[][] a = {{1, 2}, {3, 4}};
		
		assertFalse(DataUtilities.equal(a, null));
	}

}
