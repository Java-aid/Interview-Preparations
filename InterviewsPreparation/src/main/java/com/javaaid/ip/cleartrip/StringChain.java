/**
 * 
 */
package com.javaaid.ip.cleartrip;

import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class StringChain {

	static int charCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*int N = sc.nextInt();
		String words[] = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}*/
        String[] words = new String[]{"a", "b","ba", "bca", "bda", "bdca"};

		int result = calulateLongestChain(words);
		System.out.println(result);
		sc.close();
	}

	/**
	 * @param words
	 * @return
	 */
	private static int calulateLongestChain(String[] words) {
		int maxLongestChainOfCharacter = 0;
		for (String word : words) {
			int currentCharCount= findMaxChain(words, word, 0);
			maxLongestChainOfCharacter = Math.max(maxLongestChainOfCharacter, currentCharCount);

		}
		return maxLongestChainOfCharacter;
	}

	/**
	 * @param word
	 * @return
	 */
	private static int findMaxChain(String[] words, String word, int lenCounter) {
		if (!wordsContains(words, word)) {
			return 0;
		}
		lenCounter++;
		charCount = lenCounter;
		for (int i = 0; i < word.length(); i++) {
			StringBuilder sb = new StringBuilder(word);
			sb.delete(i, i + 1);
			findMaxChain(words, sb.toString(), lenCounter);
		}
		return charCount;
	}

	/**
	 * @param string
	 * @return
	 */
	private static boolean wordsContains(String[] words, String string) {
		for (String word : words) {
			if (word.equals(string)) {
				return true;
			}
		}
		return false;
	}

}
