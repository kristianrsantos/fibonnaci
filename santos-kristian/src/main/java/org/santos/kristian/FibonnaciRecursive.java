package org.santos.kristian;

import java.math.BigDecimal;

/**
 * The recursive way to generate the specified size of the numbers in 
 * a Fibonnaci sequence.
 * 
 * User passes in an integer as an argument to the main function.  This is 
 * taken as the size or the number of elements in the Fibonnaci sequence.
 * 
 * @author Kristian
 *
 */
public class FibonnaciRecursive {

	private static BigDecimal recur(int count) {
		if(count < 2)
			return new BigDecimal(count);
		else {
			return 	recur(count - 1).add(recur(count - 2));
		}				
		
	}
	
	/**
	 * Accepts an int as parameter which is the value of the size of the 
	 * set of Fibonnaci numbers. This will return an array of BigDecimal
	 * @param size
	 * @return
	 */
	public static BigDecimal[] generateFibonacciNumbers(int size) {
		if(size < 0)
			throw new IllegalArgumentException("Negative number is not allowed.");
		
		if(size > 100)
			throw new IllegalArgumentException("Limit size from 0 to 100000");
		
		BigDecimal[] array = new BigDecimal[size];
		
		for(int i=0; i<size; i++) {
			array[i] = recur(i);
			System.out.println(array[i]);
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		try {
			//LocalDateTime start = LocalDateTime.now();
			generateFibonacciNumbers(Integer.parseInt(args[0]));
			//LocalDateTime end = LocalDateTime.now();
			//System.out.println(ChronoUnit.MILLIS.between(start, end));
		}catch(NumberFormatException nfe) {
			System.out.println("Please input an integer.");
		}catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());			
		}	
	}

}
