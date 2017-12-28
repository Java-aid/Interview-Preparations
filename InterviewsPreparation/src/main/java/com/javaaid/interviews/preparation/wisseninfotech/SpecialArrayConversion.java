/**
 * 
 */
package com.javaaid.interviews.preparation.wisseninfotech;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class SpecialArrayConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int inputArray[] = new int[N];
		for (int i = 0; i < N; i++) {
			inputArray[i] = sc.nextInt();
		}
		convertArray(inputArray);
		printArray(inputArray);
		sc.close();
	}

	/**
	 * @param inputArray
	 */
	private static void convertArray(int[] inputArray) {
		int size = inputArray.length;
		int primeArray[] = new int[size];
		int nonPrimeArray[] = new int[size];
		int primeIndex = 0, nonPrimeIndex = 0, primeCount = 0, k = 0;

		for (int i = 0; i < inputArray.length; i++) {
			int num = inputArray[i];
			if (checkForPrime(num)) {
				primeArray[primeIndex++] = num;
				primeCount++;
			} else {
				nonPrimeArray[nonPrimeIndex++] = num;
			}
		}
		Arrays.sort(primeArray);
		Arrays.sort(nonPrimeArray);
		int index = primeArray.length - primeCount;
		for (; index < primeArray.length; index++) {
			if (primeArray[index] != 0) {
				inputArray[k++] = primeArray[index];
			} else {
				break;
			}

		}
		for (int i = nonPrimeArray.length - 1; i >= primeCount; i--) {
			if (nonPrimeArray[i] != 0) {
				inputArray[k++] = nonPrimeArray[i];
			} else {
				break;
			}

		}
	}

	/**
	 * @param num
	 * @return
	 */
	private static boolean checkForPrime(int num) {
		for(int i=2;2*i<num;i++) {
	        if(num%i==0)
	            return false;
	    }
	    return true;
	}

	/**
	 * @param inputArray
	 */
	private static void printArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}

	}

}
