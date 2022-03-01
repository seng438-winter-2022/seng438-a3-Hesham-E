package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.*;

public class DataUtilitiesCloneTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cloneArray() {
		double[][] source = {{1, 2}, {3, 4}};
		
		assertArrayEquals(source, DataUtilities.clone(source));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nullArray() {
		DataUtilities.clone(null);
	}
	
	@Test
	public void emptyArray() {
		double[][] source = {};
		
		assertArrayEquals(source, DataUtilities.clone(source));
	}
}
