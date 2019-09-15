package org.santos.kristian;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Test;


public class FibonnaciIterativeTest {
	
	
	/**
	 * This tests if the program is able to throw an
	 * IllegalArgumentException if a negative number
	 * is passed in as an argument to generate a sequence 
	 * of Fibonnaci numbers.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeInt() {
		int i = -1;
		FibonnaciIterative.generateFibonnaciNumbers(i);		
	}
	
	/**
	 * This tests if the method is able to reject a request
	 * to generate a very big size of a set of Fibonnaci numbers
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testForLargeSetSize() {
		int i = Integer.MAX_VALUE;
		FibonnaciIterative.generateFibonnaciNumbers(i);
	}


	/**
	 * Test to see if the method can handle a request for a 0 set
	 * of Fibonnaci numbers.
	 */
	@Test
	public void testForZeroSize() {
		BigDecimal[] numbers = FibonnaciIterative.generateFibonnaciNumbers(0);
		assertTrue(numbers.length == 0);
	}
	
	/**
	 * Test to see if 1 is passed in as the size, only one BigDecimal object is stored
	 * in the array whose value is 0. 
	 * The Fibonnaci sequence of numbers starts with 0 and 1.  These are the only numbers that
	 * do not follow the [(n-1) + (n-2)] formula to determine the value of the next number
	 * in the sequence.
	 */
	@Test
	public void testForSizeOfOne() {
		BigDecimal[] numbers = FibonnaciIterative.generateFibonnaciNumbers(1);
		assertTrue(numbers.length == 1);
		assertTrue(numbers[0].equals(new BigDecimal(0)));
	}
	
	/**
	 * Test to see if 2 is passed in as the size, only two BigDecimal objects are stored
	 * in the array whose value is 0 and 1. 
	 * The Fibonnaci sequence of numbers starts with 0 and 1.  These are the only numbers that
	 * do not follow the [(n-1) + (n-2)] formula to determine the value of the next number
	 * in the sequence.
	 */
	@Test
	public void testForSizeOfTwo() {
		BigDecimal[] numbers = FibonnaciIterative.generateFibonnaciNumbers(2);
		assertTrue(numbers.length == 2);
		assertTrue(numbers[0].equals(new BigDecimal(0)));
		assertTrue(numbers[1].equals(new BigDecimal(1)));
	}
	
	/**
	 * This is to test if the generated numbers truly follows the Fibonnaci sequence.
	 * This limits the size of the requested set of numbers to 1000. 
	 * It will then randomly get the Fibonnaci number value at the randomIndex.  
	 * The randomIndex is any value in between 3 to 1000. 
	 * It will test if the value is the sum of the previous two numbers in the sequence. 
	 * 
	 * Basically, this should apply
	 * N(randomIndex) = N(randomIndex -1) + N(randomIndex -2)
	 */
	@Test
	public void testNumberIfSumOfTwoPreviousNumbers() {
		int sizeOfSet = 1000;
		
		Random random = new Random();
		int randomIndex = (random.ints(3, sizeOfSet).limit(1).findFirst().getAsInt()) - 1;
		
		BigDecimal[] numbers = FibonnaciIterative.generateFibonnaciNumbers(sizeOfSet);

		assertTrue(numbers[randomIndex].equals((numbers[randomIndex-1].add(numbers[randomIndex -2]))));
		
	}
	
	
}
