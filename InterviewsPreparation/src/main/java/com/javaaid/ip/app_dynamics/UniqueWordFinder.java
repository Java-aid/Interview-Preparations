/**
 *Problem Statement-
 *------------------------------
 *There is a file containing plain text, you need to tell whether all the unique words in whole file is present in single line or not?
	Ex- 
	input->
	a
	a b
	b c d
	a b c d
	
	output->yes
	
	input->
	a
	a b
	b c d
	a b c d
	e
	
	output->no
	Note: treat character as words for ease
 
 */

package com.javaaid.ip.app_dynamics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Kanahaiya Gupta
 *
 */
public class UniqueWordFinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int lineCount = sc.nextInt();
			sc.nextLine();
			String[] lines = new String[lineCount];
			for (int i = 0; i < lineCount; i++) {
				lines[i] = sc.nextLine();
			}
			boolean result = getUniqChar(lines);
			System.out.println(result ? "YES" : "NO");
		}
		sc.close();
	}

	private static boolean getUniqChar(String[] lines) {
		Set<String> gWords = new HashSet<String>();
		int globalSize = 0, localMax = 0;
		for (String line : lines) {
			Set<String> lWords = new HashSet<String>();
			String words[] = line.split(" ");
			for (String word : words) {
				lWords.add(word);
			}
			localMax = Math.max(localMax, lWords.size());
			gWords.addAll(lWords);
			globalSize = Math.max(globalSize, gWords.size());
		}
		return (globalSize == localMax);
	}

}
