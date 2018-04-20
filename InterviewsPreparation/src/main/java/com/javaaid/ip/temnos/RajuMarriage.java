/**
 *Problem statement-
 *--------------------------------
 *Raju and marriage ceremony (100 Marks)
Raju is attending a marriage ceremony. There are lot of people who are coming and going from the gate. Raju is standing near the gate and observing everything. There are
N persons and for each person Raju knows A and B which is the time interval in seconds [A , B ] in which a person is present at the gate. Now Raju wants to answer 2
queries:
Query 1: The maximum number of people which can be present at the gate at any point of time.
Query 2: The maximum time at which there are exactly P people standing at the gate.
Note: If there is no such time for Query 2 then output -1 for the query.
Input Format
First line of input contains an Integer N i.e. the number of rows.
Second line of input contains Integer 2 i.e. the number of columns.
Next N lines of input containing two space separated integers A and B .
Next line contains an Integer P.
Constraints
1 <= N <= 100000
1 <= A <= B <= 10
1 <= P <= 100000
Output Format
2 space separated integer denoting answer to the Query1 and Query2 respectively.
Sample TestCase 1
Input
5
2
1 4
3 5
3 8
5 9
4 10
3
Output
4 8
Explanation
Query 1: The maximum number of people which can be present at the gate at any point of time.
1 2 3 4
3 4 5
3 4 5 6 7 8
5 6 7 8 9
4 5 6 7 8 9 10
Here, in this case at point of time 4 and 5 - we have maximum 4 people. Hence, answer for Query 1 is 4.
Query 2: The maximum time at which there are exactly P people standing at the gate.
1 2 3 4
3 4 5
3 4 5 6 7 8
5 6 7 8 9
4 5 6 7 8 9 10
Here, P=3, So, 8 will be maximum common time for 3 people standing at the gate at one time.
 */

package com.javaaid.ip.temnos;

import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class RajuMarriage {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int maxNoOfGuest = Integer.MIN_VALUE;
		int maxTime = -1;
		int N = sc.nextInt();
		sc.nextInt();
		int a[] = new int[1000001];
		for (int i = 0; i < N; i++) {
			fillArray(a, sc.nextInt(), sc.nextInt());
		}
		int P = sc.nextInt();
		for (int i = 1; i <=1000000 ; i++) {
			if (a[i]!=0 &&a[i] > maxNoOfGuest) {
				maxNoOfGuest = a[i];
			}
			if ( a[i] == P) {
				maxTime = i;
			}

		}
		System.out.println(maxNoOfGuest);
		System.out.println(maxTime);
		sc.close();
	}

	/**
	 * @param nextInt
	 * @param nextInt2
	 */
	private static void fillArray(int a[], int start, int end) {
		for (int i = start; i <= end; i++) {
			a[i]++;
		}

	}
}
