/**
*problem statement-
	-------------------------------------
	Given an integer array as input, find out the integers which contains the digits 1,2,3 numbers in its formation . The order of 1,2,3 need
	not be sequential.
	In case multiple numbers qualifies the condition, The outcome should be ordered based on numeric value (lesser number first followed
	by greater number and so on..) and separated by comma.
	In case no number qualifies the conditions, it should return -1.
	Example:
	Input :
	1456
	345671
	43218
	123
	Output: 123,43218
	Explanation: In the above example, as there are 2 numbers(43218,123) which qualifies the condition, we need to sort the output in
	ascending order seperated by comma.
 * 
 */
package com.javaaid.interviews.preparation.goldmansachs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class NumberChecker {
	static String findQualifiedNumbers(int[] numberArray) {
		Arrays.sort(numberArray);
		String num = "", res = "";
		for (int i : numberArray) {
			num = i + "";
			if (num.indexOf("1") != -1 && num.indexOf("2") != -1 && num.indexOf("3") != -1) {
				res += i + ",";
			}
		}
		return res.equals("") ? "-1" : res.substring(0, res.length() - 1);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		String res;
		int numberArray_size = 0;
		numberArray_size = Integer.parseInt(in.nextLine().trim());

		int[] numberArray = new int[numberArray_size];
		for (int i = 0; i < numberArray_size; i++) {
			int numberArray_item;
			numberArray_item = Integer.parseInt(in.nextLine().trim());
			numberArray[i] = numberArray_item;
		}

		res = findQualifiedNumbers(numberArray);
		bw.write(res);
		bw.newLine();

		bw.close();
	}
}
