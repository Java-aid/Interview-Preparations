/**
Microsoft coding test for SDET
calculate Nck for given n & k
 * 
 */
package com.javaaid.ip.microsoft;

/**
 * @author Kanahaiya Gupta
 *
 */
public class CalculateCombinations {

	static long calculateCombinations(int n, int k) {
		int cache[] = new int[k + 1];
		cache[0] = 1;

		for (int i = 1; i <= n; i++) {
			int tmp=Math.min(i, k);
			for (int j = tmp; j > 0; j--)
				cache[j] = cache[j] + cache[j - 1];
		}
		return cache[k];
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int n = 100, k = 2;
		System.out.printf("Value of C(%d, %d) is %d ", n, k, calculateCombinations(n, k));
	}
}