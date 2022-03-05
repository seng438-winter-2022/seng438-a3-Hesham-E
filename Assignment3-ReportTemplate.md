**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \# : 12    |     |
| -----------------| --- |
| Tom Altankhuyag  |     |
| Hasan Mahtab     |     |
| Asma Hashmi      |     |
| Hesham Elkaliouby|     |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

This lab covered unit testing once again. However this time, the lab focuses more onto White-Box testing. The objective of this lab is to introduce us to the concepts of determining the adequecy of White-Box test suite based on its covergae. This type of testing uses control-flow coverage criteria. Three coverage types were looked into: Statement, Branch, Method. The unit testing was done with JUnit in Eclipse using Eclemma.

Going into this lab, the group no previous knowledge or experience on White-Box testing beyond what was already taught in lectures and through class examples. After this lab assignment, we have gained knowledge about the tools and the testing metrics used in White-Box testing.

# 2 Manual data-flow coverage calculations for X and Y methods

## getCentralValue()
![Figure2_1](/figure/getCentralValue()DFG.png)
### DU-pairs per statement
| Node | Def | Use |
| -----|-----| --- |
| 1 | | this.lower, this.upper|

### DU-pairs per variable:
* this.upper (class def, 1)
* this.lower (class def, 1)
### DU-pair coverage per test:
* valueShouldBe2()
   * for this.upper (class def, 1)
   * for this.lower (class def, 1)
   * 2 pairs (100% DU-Pair coverage)
* valueShouldBe1_5()
   * for this.upper (class def, 1)
   * for this.lower (class def, 1)
   * 2 pairs (100% DU-Pair coverage)
* valueShouldBe1()
   * for this.upper (class def, 1)
   * for this.lower (class def, 1)
   * 2 pairs (100% DU-Pair coverage)
* valueShouldBe35_9 ()
   * for this.upper (class def, 1)
   * for this.lower (class def, 1)
   * 2 pairs (100% DU-Pair coverage)
* valueShouldBe0 ()
   * for this.upper (class def, 1)
   * for this.lower (class def, 1)
   * 2 pairs (100% DU-Pair coverage)

## calculateColumnTotal()
![Figure2_2](/figure/calculateColumnTotal()DFG.png)
### DU-pairs per statement:
| Node | Def | Use |
| -----|-----| --- |
| 1 | data, row, total, columnCount| data |
| 2 | c | c, columnCount |
| 3 | n | row, c, n, data |
| 4 | | total, n|
| 5 | | total|

### DU-pairs per variable
* for data (1, 1) (1, 3)
* for row (1, 3)
* for total (1, 4) (1, 5)
* for columnCount (1, 2)
* for c (2, 2) (2, 3)
* for n (3, 3) (3, 4)
### DU-pair coverage per test:
* calculateTwoValues()
   * for data (1, 1) (1,3)
   * for row (1, 3)
   * for total (1, 4) (1, 5)
   * for columnCount (1, 2)
   * for c (2, 2) (2, 3)
   * for n (3, 3) (3, 4)
   * 10 pairs (100% DU-Pair 
* calculateColumnIndexOutofRange()
   * for data (1, 1) (1,3)
   * for row (1, 3)
   * for total (1, 5)
   * for columnCount (1, 2)
   * for c (2, 2) (2, 3)
   * for n (3, 3)
   * 8 pairs (80% DU-Pair coverage)
* calculateColumnIndexNegative()
   * for data (1, 1) (1,3)
   * for row (1, 3)
   * for total (1, 5)
   * for columnCount (1, 2)
   * for c (2, 2) (2, 3)
   * for n (3, 3)
   * 8 pairs (80% DU-Pair coverage)
* tableHasZeroRows()
   * for data (1, 1)
   * for total (1, 4) (1, 5)
   * for columnCount (1, 2)
   * for c (2, 2)
   * 5 pairs (50% DU-Pair coverage)
* dataObjectInvalid()
   * for data (1, 1)
   * 1 pair (10% DU-Pair coverage)


# 3 A detailed description of the testing strategy for the new unit test

At first, the group evaluated the old testing cases used for blackbox testing in the previous assignment. We evaluated the coverage metrics (branch, statement, and method) in the scope of the two classes: Range and DataUtilities. We realized that our previous test cases were not sufficient for the requirements of this lab, therefore, we developed new test cases for the methods within these two classes.

Our testing plan primairly followed the specifications and was supplimented by looking at the source code itself. In this way, we were able to develop test cases based on the javadocs provided and by guessing how the function was implemented. However, in some cases, looking at the code itself was necessary to move forward if the specifications were not sufficient to develop test cases from.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Test case 1: ```firstNaNSecondNull()``` for ```public static Range combineIgnoringNaN(Range range1, Range range2)``` inside ```Range```.   
```java
     @Test
	public void firstNaNSecondNull() {
		testRange = new Range(0,0);
		temp1 = new Range(Double.NaN,Double.NaN);
		
		testRange = Range.combineIgnoringNaN(temp1, null);
		
		assertNull("range should be null", testRange);
	}
```
The coverage is increased from:  
![Figure1_1](/figure/1_1.PNG)  

To:  

![Figure1_0](/figure/1_0.PNG)  
  
Test case 2: ```bothRangeAreNull()``` for ```public static Range combineIgnoringNaN(Range range1, Range range2)``` inside ```Range```.  
```java
    @Test
	public void bothRangeAreNull() {
		
		testRange = new Range(0,0);
		
		testRange = Range.combineIgnoringNaN(null, null);
		assertTrue("range object should be null",  Objects.isNull(testRange));
	}
```
The coverage is increased from:  
![Figure2_0](/figure/2_0.PNG)  

To:  

![Figure2_1](/figure/1_0.PNG)  

Test case 3: ```secondRangeIsNull()``` for ```public static Range combineIgnoringNaN(Range range1, Range range2)``` inside ```Range```.  
```java
	@Test
	public void secondRangeIsNull() {
		
		testRange = new Range(0,0);
		temp1 = new Range(-1,5);
		
		testRange = Range.combine(temp1, null);
		assertSame("testRange should be equivalent to temp1", temp1,testRange);
```
The coverage is increased from:  
![Figure1_0](/figure/3_0.PNG)  

To:  

![Figure3_0](/figure/1_0.PNG)  

Test case 4: ```newLowerValue()``` for ```public static Range expandToInclude(Range range, double value)``` inside ```Range```.
```java
@Test
	public void newLowerValue() {
		testRange = new Range(-5,5);
		
		testRange = Range.expandToInclude(testRange, -5.1);
		
		 temp = new Range(-5.1,5);
		assertEquals("The new lower should be -5.1", -5.1,testRange.getLowerBound(),0);
	}
```
The coverage is increased from:  
![Figure1_0](/figure/4_0.PNG)  

To:  

![Figure4_0](/figure/1_0.PNG)  

Test case 5: ```newUpperValue()``` for ```public static Range expandToInclude(Range range, double value)``` inside ```Range```.
```java
@Test
	public void newUpperValue() {
		testRange = new Range(-5,5);
		
		testRange = Range.expandToInclude(testRange, 5.1);
		
		 temp = new Range(-5,5.1);
		assertEquals("the new upper should be 5.1", 5.1,testRange.getUpperBound(),0);
	}
```
The coverage is increased from:  
![Figure5_0](/figure/5_0.PNG)  

To:  

![Figure1_0](/figure/1_0.PNG)  


# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)
# org.jfree.data.Range:  

![rangeClass](/figure/rangeCLASS.PNG)  

![combine](/figure/combine.PNG)  

![combineIgnore](/figure/combineIgnoringNaNTest.PNG)  

![expand](/figure/combineIgnoringNaNTest.PNG)  

![expandToInclude](/figure/expandtoincludetest.PNG)  

![max](/figure/max.PNG)  

![min](/figure/min.PNG)  

![scale](/figure/scaletest.PNG)  

![shift](/figure/shift1.PNG)  

![shiftWithZero](/figure/shiftwithoutzero.PNG)  

![equals](/figure/equaltest.PNG)  

![getCentralValue](/figure/getcentralvaluetest.PNG)  

![getLength](/figure/getlengthtest.PNG)  

![upperBoundary](/figure/upperboundary.PNG)  

![lowerBoundary](/figure/lowerboundary.PNG)  

![contains](/figure/contains.PNG)  

![hash](/figure/hashcode.PNG)  

![toString](/figure/tostring.PNG)  



# org.jfree.data.DataUtilities:  

![dataUtillities](/figure/dataUtilCLASS.PNG)  

![columnTotal](/figure/columntotaltest.PNG)  

![columnTotalOverload](/figure/columntotaltestoverload.PNG)  

![rowTotal](/figure/rowtotal.PNG)  

![rowTotalOverload](/figure/rowtotaloverload.PNG)  

![clone](/figure/clonetest.PNG)  

![createNumArray](/figure/createarraytest.PNG)  

![equal](/figure/equaltest.PNG)  

![getCumulative](/figure/getcumulativepercentages.PNG)  


# 6 Pros and Cons of coverage tools used and Metrics you report

In this lab, EclEmma was used to measure the coverages within the class and methods. Upon using the coverage tool, the pros included extensive coverage information and even code highlighting to indicate if certain part of the source code had been tested or not. However, we realized that certain unit tests does not affect the coverage percentage within a test suite but still affects the overall coverage of the class under test (Example below).

We will use the method ```public static Range combineIgnoringNaN(Range range1, Range range2)``` as example.

Seen below, with the unit test commented out, our coverages for the suite are all hundred percent despite still have a statement not covered.  

![Figure6_0](/figure/6_0.PNG)  

We can clearly see a line is still not covered despite the coverage tool insisting that the coverages are at a hundred percent.    

![Figure6_3](/figure/6_3.PNG)  

With the test added, we can see our coverage measurement inside ```Range```.    

![Figure6_1](/figure/6_1.PNG)  

And without the unit test, we can see our class' coverage lowered.  

![Figure6_2](/figure/6_2.PNG)  

So as a result, EclEmma is still a fantastic coverage tool, but it can not confidently represent the accurate coverage of method/class under test. Overall the tool is still deemed to be very helpful and useful to check our overall coverages and especially the statement and branch coverages.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements-based testing is a test approach  where test cases, conditions, and data are derived from the requirements. It will include both functional and non-functional attributes, such as usability, performance, reliability. Coverage-based testing is done by designing test situations and test cases with test design techniques. 

When compared to coverage testing, requirements testing gives a development team confidence over the simple/hard requirements of the final application. For example, a place where requirements testing would be preferred is in an account log in page where text fields are restricted to certain characters because boundary value testing is part of requirements testing. On the other hand, coverage testing is more useful for reliability and soft requirements. For example, coverage testing is useful for testing all paths in the program where possible. Sometimes this is not realistic, however, since programs can be too large in size. This is one downside of coverage based testing where it is dependent on covering the program.

# 8 A discussion on how the team work/effort was divided and managed

Each team member was assigned a portion of methods to create test cases for in order to increase coverage. For example, in the Range class, three group members were assigned four methods to test each. The final group memeber was assigned the DataUtilities class since it was smaller to develop test cases for. As test cases were developed, they were uploaded onto the GitHub to collect onto one device to measure coverage for both classes.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

The biggest lesson learned from this lab was that sometimes tools may not be sufficient for the tasks that we need them for as testers. For example, EclEmma is not able to measure condition coverage, and thus, we had to substitute that for method coverage. From this we learned that project goals may have to be shifted in order to match the tools that we are given. Otherwise, a testing team would have to switch tools entirely.

# 10 Comments/feedback on the lab itself

Overall, it was a good introductory lab for us to learn about code coverage. However, there were no clear instructions in the assignment on how to use EclEmma step by step.
