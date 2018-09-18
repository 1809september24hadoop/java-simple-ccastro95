package com.revature.simple;

import org.apache.log4j.Logger;

public class JavaSimpleSolution implements JavaSimple {

	private static final Logger LOGGER = Logger.getLogger(JavaSimpleSolution.class);

	@Override
	public int castToInt(double n) {
		int i = 0;
		i = (int) n;
		LOGGER.info("f(" + n + ") = " + i);
		return i;
	}

	@Override
	public byte castToByte(short n) {
		byte b = 0;
		b = (byte) n;
		LOGGER.info("f(" + n + ") = " + b);
		return b;
	}

	@Override
	public double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		double div = operandOne / operandTwo;

		if (operandTwo == 0) {
			try {
				throw new IllegalArgumentException("Error: The second digit cannot be a 0. Please try again later.");
			} catch (IllegalArgumentException e) {
				LOGGER.error(e);
			}
		} else {
			LOGGER.info("f(" + operandOne + ", " + operandTwo + ") = " + div);
		}
		return div;
	}

	@Override
	public boolean isEven(int n) {
		int o = n / 2;

		/*
		 * What is done in the next set of code is the comparison of the original parameter
		 * and the value of o multiplied by 2.
		 * This comparison works as the int o will only print out a whole number.
		 * If n is an odd number, the argument provided in the if statement will not be true
		 * as o * 2 will be an even number.
		 */

		if (n == o * 2) {
			LOGGER.info("f(" + n + ") = true");
			return true;
		} else {
			LOGGER.info("f(" + n + ") = false");
			return false;
		}
	}

	@Override
	public boolean isAllEven(int[] array) {
		if (array == null) {
			try {
				throw new IllegalArgumentException("Error: In order to operate properly, the array must not be empty.");
			} catch (IllegalArgumentException e) {
				LOGGER.error(e);
			}
		} else {
			for(int i: array) {
				if(i % 2 != 0) {
					LOGGER.info("false");
					return false;	
				} else {
					LOGGER.info("true");
					return true;
				}
			}	
		}
		return false;
	}

	@Override
	public double average(int[] array) throws IllegalArgumentException {
		double sum = 0.0;
		double average = 0.0;
		if (array == null) {
			try {
				throw new IllegalArgumentException("Error: In order to find a proper average, the array must not be empty.");
			} catch (IllegalArgumentException e) {
				LOGGER.error(e);
			}
		} else {
			for(int i: array) {
				sum += i;
			}
			average = sum/array.length;
			LOGGER.info(average);
		}
		return average;
	}

	@Override
	public int max(int[] array) throws IllegalArgumentException {
		int max = 0;
		if (array == null) {
			try {
				throw new IllegalArgumentException("Error: In order to find a max value, the array must not be empty.");
			} catch (IllegalArgumentException e) {
				LOGGER.error(e);
			}
		} else {
			for(int i = 0; i < array.length; i++) {
				if(i == 0) {
					max = array[0];
				} else {
					if(array[i] > max) {
						max = array[i];
					}
				}
			}
			LOGGER.info(max);
		}
		return max;
	}

	@Override
	public int fibonacci(int n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] sort(int[] array) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int factorial(int n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] rotateLeft(int[] array, int n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isPrime(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		new JavaSimpleSolution().castToInt(0.0);
		new JavaSimpleSolution().castToInt(3.1);
		
		new JavaSimpleSolution().castToByte((short) 2);
		new JavaSimpleSolution().castToByte((short) 128);
		
		new JavaSimpleSolution().divide(10, 2);
		new JavaSimpleSolution().divide(3, 2);
		
		new JavaSimpleSolution().isEven(2);
		new JavaSimpleSolution().isEven(3);

		int[] firstArray = {2};
		int[] secondArray = {2, 4, 6, 8, 10};
		int[] thirdArray = {3};
		int[] fourthArray = {2,4,6,8,11};
		int[] nullArray = null;

		new JavaSimpleSolution().isAllEven(firstArray);
		new JavaSimpleSolution().isAllEven(secondArray);
		new JavaSimpleSolution().isAllEven(thirdArray);
		new JavaSimpleSolution().isAllEven(fourthArray);
		new JavaSimpleSolution().isAllEven(nullArray);

		int[] averageArray = {2,3};

		new JavaSimpleSolution().average(firstArray);
		new JavaSimpleSolution().average(averageArray);
		new JavaSimpleSolution().average(nullArray);

		int[] maxOne = {10,2,4,7,9};
		int[] maxTwo = {10,10,13,13,14,15,17,17};

		new JavaSimpleSolution().max(maxOne);
		new JavaSimpleSolution().max(maxTwo);
		new JavaSimpleSolution().max(nullArray);
	}

}
