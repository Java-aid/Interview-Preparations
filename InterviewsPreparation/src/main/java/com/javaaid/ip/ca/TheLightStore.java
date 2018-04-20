/**
 * 
 */
package com.javaaid.ip.ca;

import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class TheLightStore {

	private static int getOpCount(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String output = sc.next();
		int result = getOpCount(input, output);
		System.out.println(result);
	}
}
