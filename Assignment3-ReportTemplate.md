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


This lab covered unit testing once again, but this time it was about White-Box testing. The objective of this lab is to introduce us to the concepts of determining the adequecy of white-box test suite based on its covergae. This type of testing can take many forms, including control-flow coverage criteria. Three coverage types were looked into: Statement, Branch, Condition. The unit testing was done with JUnit in Eclipse. Testing tools like EclEclemma is used followed by the implementation of the test suite. 

# 2 Manual data-flow coverage calculations for X and Y methods

![Figure2_1](/figure/getCentralValue() DFG.PNG)
![Figure2_2](/figure/calculateColumnTotal() DFG.PNG)

# 3 A detailed description of the testing strategy for the new unit test

There are three coverage based metrics that were implemented: branch, statement, and condition. First the original unit tests were tested for coverage, to see where new tests can be added. All the datautilities and range classes were tested. After writing in test cases, we tested for the coverage, which was almost always 100%. 

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

For the first example, we will a test case from the method ```public static Range combineIgnoringNaN(Range range1, Range range2)``` inside ```Range```.   
poop

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

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



# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
