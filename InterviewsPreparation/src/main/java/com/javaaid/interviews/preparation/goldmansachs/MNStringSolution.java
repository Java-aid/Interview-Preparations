/**
 * 
 */
package com.javaaid.interviews.preparation.goldmansachs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class MNStringSolution {
	static PriorityQueue<Integer> heap = new PriorityQueue<Integer>();;

	/*
	 * Complete the function below.
	 */
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		if (validatePattern(pattern))
			return -1;
		return Integer.parseInt(processString(pattern));

	}

	/**
	 * @param pattern
	 * @return
	 */
	private static boolean validatePattern(String pattern) {
		return (pattern.equals("") || pattern == "" || pattern == " " || pattern == null
				|| getMNCount(pattern) != pattern.length());
	}

	/**
	 * @param c
	 * @return
	 */
	private static int getMNCount(String pattern) {
		int mCount = 0, nCount = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == 'M') {
				mCount++;
			}
			if (pattern.charAt(i) == 'N') {
				nCount++;
			}
		}
		return nCount + mCount;
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

		int res;
		String pattern;
		try {
			pattern = in.nextLine();
		} catch (Exception e) {
			pattern = null;
		}

		res = findPossibleSmallestNumberMatchingPattern(pattern);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
	}

	/**
	 * @param input
	 * @return
	 */
	private static String processString(String input) {
		String res = "";
		int len = input.length();
		for (int k = 1; k <= len + 1; k++)
			heap.add(k);
		int mCount = 0;
		int nCount = 0;
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == 'M') {
				mCount = getConsecutiveCount(input, i, 'M');
				res += getElement(mCount + 1);
				mCount = 0;
			} else {
				res += getElement(1);
				nCount = 0;
			}

		}
		return res + heap.poll();
	}

	public static int getConsecutiveCount(String input, int index, char ch) {
		int c = 0;
		for (int i = index; i < input.length(); i++) {
			if (input.charAt(i) == ch) {
				c++;
			} else {
				break;
			}
		}
		return c;

	}

	private static String getElement(int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int tmp = 0, c = 0;

		while (k-- > 0) {
			tmp = heap.poll();
			c++;
			if (k > 0) {
				pq.add(tmp);
			} else {
				break;
			}
		}
		heap.addAll(pq);
		return tmp + "";
	}

}
