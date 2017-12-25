/**
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
