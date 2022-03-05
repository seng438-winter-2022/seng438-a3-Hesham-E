package org.jfree.data.test;
import org.jfree.data.Range;
import static org.junit.Assert.*;

import org.junit.*;

public class LengthTest {

	@Test
	public void Num() {
		assertEquals("Incorrect length return", 9, new Range(1,10).getLength(), .000000001d);
	}

	@Test
	public void SameNum() {
		assertEquals("Not returning 0", 2, new Range(1,3).getLength(), .000000001d);  //testing to see if 0 is returned when same values are used
	}
	
	@Test
	public void SameNumNeg() {
		assertEquals("Not returning 0", 2, new Range(-3,-1).getLength(), .000000001d);  //testing to see if 0 is returned when same values (negative) are used
   }
}