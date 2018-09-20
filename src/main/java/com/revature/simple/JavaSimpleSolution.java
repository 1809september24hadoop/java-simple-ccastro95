package com.revature.simple;

import java.util.Arrays;
import java.util.Stack;

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
		if(operandTwo == 0) {
			throw new IllegalArgumentException("Error: The second digit cannot be a 0. Please try again later.");
		}

		double div = operandOne / operandTwo;
		LOGGER.info("f(" + operandOne + ", " + operandTwo + ") = " + div);
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
			throw new IllegalArgumentException("Error: In order to operate properly, the array must not be empty.");
		}
		for(int i: array) {
			new JavaSimpleSolution().isEven(i);
		}	
		return false;
	}

	@Override
	public double average(int[] array) throws IllegalArgumentException {
		double sum = 0.0;
		double average = 0.0;
		if (array == null) {
			throw new IllegalArgumentException("Error: In order to find a proper average, the array must not be empty.");
		}
		for(int i: array) {
			sum += i;
		}
		average = sum/array.length;
		LOGGER.info(average);
		return average;
	}

	@Override
	public int max(int[] array) throws IllegalArgumentException {
		int max = 0;
		if (array == null) {
			throw new IllegalArgumentException("Error: In order to find a max value, the array must not be empty.");
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		LOGGER.info(max);
		return max;
	}

	@Override
	public int fibonacci(int n) throws IllegalArgumentException {

		if(n < 0) {
			throw new IllegalArgumentException("Error: The fibonacci value cannot be less than 0.");
		}
		int fibonacci = 0;

		/*
		 * The value of 2 was chosen to be added as this would keep the array values
		 * following this line below from going out of bounds of the array's dimensions
		 * if the user were to enter a 0 or 1.
		 */
		int[] array = new int[n+2];

		array[0] = 0;
		array[1] = 1;
		for(int i = 0; i <= n; i++) {
			if(i >= 2) {
				array[i] = array[i - 1] +  array[i - 2];
			}
			if(i == n) {
				fibonacci = array[i];
				LOGGER.info(fibonacci);	
			}
		}
		return fibonacci;
	}

	@Override
	public int[] sort(int[] array) throws IllegalArgumentException {

		if (array == null) {
			throw new IllegalArgumentException("Error: In order to find sort existing values in an array,"
					+ " the array must not be empty.");
		}

		LOGGER.info("Array sorted before: " + Arrays.toString(array));

		//Bubble sort
		for(int i = 0; i < array.length - 1; i++) {
			int temp;
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
		LOGGER.info("Array sorted after: " + Arrays.toString(array));
		return array;		
	}

	@Override
	public int factorial(int n) throws IllegalArgumentException {
		int result = 1;
		for (int i = 0; i <= n; i++) {
			if(i == 0) {
				result = 1;
			} else {
				result = result * i;
			}
		}
		LOGGER.info(result);
		return result;
	}

	@Override
	public int[] rotateLeft(int[] array, int n) throws IllegalArgumentException {

		if (array == null) {
			throw new IllegalArgumentException("Error: In order to rotate existing values in an array,"
					+ " the array must not be empty.");
		} else if (n < 0) {
			throw new IllegalArgumentException("Error: The amount of rotations cannot be negative."
					+ " Please try again later.");
		}

		LOGGER.info("Array rotated before: " + Arrays.toString(array));

		for(int i = 0; i < n; i++) {

			/*
			 * The parameters in the following for loop keep the enclosed lines
			 * from accessing any indices outside of the array bounds.
			 * (The array bounds are from 0 to array.length - 1.)
			 */
			for(int j = 1; j <= array.length - 1; j++) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
		}

		LOGGER.info("Array rotated after: " + Arrays.toString(array));
		return array;
	}

	@Override
	public String isPrime(int n) {

		if (n < 0) {
			throw new IllegalArgumentException("Error: The input number cannot be negative."
					+ " Please try again later.");
		}

		/*
		 * Int i will be starting at 2, because 0 and 1 are special cases
		 * and do not fall under the prime or composite categories.
		 * (In addition, you cannot divide by 0, so the expression in the
		 * if statement would not work if i = 0.)
		 */
		for(int i = 2; i < n; i++) {
			int result = n % i;
			if(result == 0) {
				LOGGER.info("This is not prime.");
				return new String("This is not prime.");
			}
		}
		LOGGER.info("This is prime.");
		return new String("This is prime.");
	}

	@Override
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {

		if (brackets == null) {
			throw new IllegalArgumentException("Error: In order to check for balanced brackets,"
					+ " the input string must not be empty.");
		}		

		/*
		 * Stack is an extension of the class Vector.
		 * The stack exists as a Last-In-First-Out (LIFO) order of variables.
		 * To retrieve any of the values within the stack, the methods
		 * 'push' and 'pop' are used.
		 * 
		 * In the case of the stack for this for loop, the opening brackets will be pushed into the stack.
		 * The code will then check to see if the popped item (the first one in the stack will be out)
		 * corresponds with the character currently being looked at (the last to be put into the stack).	
		 */
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < brackets.length(); i++) {
			char c = brackets.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				s.push(c);
			} else if(c == ')') {
				if(s.isEmpty() || s.pop() != '(') {
					LOGGER.info("This string is not balanced.");
					return false;
				}
			} else if(c == ']') {
				if(s.isEmpty() || s.pop() != '[') {
					LOGGER.info("This string is not balanced.");
					return false;
				}
			} else if(c == '}') {
				if(s.isEmpty() || s.pop() != '{') {
					LOGGER.info("This string is not balanced.");
					return false;
				}	
			}
		}
		LOGGER.info("This string is balanced.");
		return s.isEmpty();
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
		int[] fourthArray = {2, 6, 4, 8, 11, 1};
		int[] nullArray = null;

		new JavaSimpleSolution().isAllEven(firstArray);
		new JavaSimpleSolution().isAllEven(secondArray);
		new JavaSimpleSolution().isAllEven(thirdArray);
		new JavaSimpleSolution().isAllEven(fourthArray);

		int[] averageArray = {2,3};

		new JavaSimpleSolution().average(firstArray);
		new JavaSimpleSolution().average(averageArray);

		int[] maxOne = {10,2,4,7,9};
		int[] maxTwo = {10,10,13,13,14,15,17,17};

		new JavaSimpleSolution().max(maxOne);
		new JavaSimpleSolution().max(maxTwo);

		new JavaSimpleSolution().fibonacci(0);
		new JavaSimpleSolution().fibonacci(1);
		new JavaSimpleSolution().fibonacci(10);

		new JavaSimpleSolution().sort(maxOne);
		new JavaSimpleSolution().sort(fourthArray);

		new JavaSimpleSolution().factorial(0);
		new JavaSimpleSolution().factorial(1);
		new JavaSimpleSolution().factorial(3);

		new JavaSimpleSolution().rotateLeft(maxTwo, 2);
		new JavaSimpleSolution().rotateLeft(fourthArray, 3);

		new JavaSimpleSolution().isPrime(123);
		new JavaSimpleSolution().isPrime(29);

		new JavaSimpleSolution().balancedBrackets("({[]})");
		new JavaSimpleSolution().balancedBrackets("([)]");
	}

}
