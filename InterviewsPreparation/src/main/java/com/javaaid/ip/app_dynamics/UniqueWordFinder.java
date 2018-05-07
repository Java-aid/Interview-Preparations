/**
 * Problem Statement-
 * ------------------------------
 * There are lot of meeting which has been schedule for today and schedule of meetings has been provide based on that you need to arrange minimum rooms so that nobody has to wait for meeting room as cost of meeting room is also high, so arrange less meeting room for all the meetings.
	
	input--> (startTime,endTime)
	(1,4),(2,8),(3,6)
	output- 3
	
	input--> (1,5),(2,6),(6,8),(7,9)
	output-> 2
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
