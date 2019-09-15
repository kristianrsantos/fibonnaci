package org.santos.kristian;

import java.math.BigDecimal;

/**
 * Generates an array of BigDecimals that follow the Fibonnaci sequence. 
 * The generation of the numbers is done through iteration.
 * 
 * User passes in an integer as an argument to the main function.  This is 
 * taken as the size or the number of elements in the Fibonnaci sequence.
 * 
 * @author Kristian
 *
 */
public class FibonnaciIterative {
	
	/**
	 * The method accepts the size of a sequence of Fibonnaci numbers 
	 * and returns an array of BigDecimal which contains the n number of 
	 * Fibonnaci numbers in sequence.
	 * <p>
	 * When 5 is passed in, it returns an array of size 5 whose values
	 * are the first 5 numbers in the Fibonnaci sequence.
	 * 
	 * Although an array can have a size equal to the maximum int value minus one, 
	 * this method limits the size to 100000.  
	 *  
	 * @param size
	 * @return
	 */
	public static BigDecimal[] generateFibonnaciNumbers(int size) {
		if(size < 0)
			throw new IllegalArgumentException("Negative number is not allowed.");
		
		if(size > 100000)
			throw new IllegalArgumentException("Limit size from 0 to 100000");
		
		BigDecimal[] array = new BigDecimal [size];
		
		for(int i=0; i<size; i++) {
			if(i<2) 
				array[i] =new BigDecimal(i);
			else {
				array[i] = array[i-1].add(array[i-2]);
			}
			
			System.out.println(array[i]);
		}
		
		return array;
	}
	
	public static void main(String args[]) {
		try {
			//LocalDateTime start = LocalDateTime.now();
			generateFibonnaciNumbers(Integer.parseInt(args[0]));
			//LocalDateTime end = LocalDateTime.now();
			//System.out.println(ChronoUnit.MILLIS.between(start, end));
		}catch(NumberFormatException nfe) {
			System.out.println("Please input an integer.");
		}catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());			
		}		
		
	}

}
