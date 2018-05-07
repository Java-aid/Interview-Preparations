/**
 * 
 */
package com.javaaid.ip.app_dynamics;

import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class Solution1 {
	public static int maxProfit(int[] a) {
		int max_so_far = 0, curr_max = 0;
		for (int i = 1; i < a.length; i++) {
			curr_max += a[i] - a[i - 1];
			curr_max = Math.max(curr_max, 0);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far <= 0 ? -1 : max_so_far;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int result = maxProfit(a);
		System.out.println(result);
	}

}
