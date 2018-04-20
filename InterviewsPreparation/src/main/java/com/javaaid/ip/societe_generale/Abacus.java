/**
Abacus
This is a problem that deals with the use of abacii. If you are not familiar with the way
abacii work, please take a look at [this link] (http://www.wikihow.com/Use-an-Abacus
(http://www.wikihow.com/Use-an-Abacus)).
To summarize, the abacus we are dealing with in this problem consists of two sets of
beads separated by a barrier.
The 􀁾rst set of beads (the top), is called heaven beads while the bottom set is known as
earth beads. The heaven beads are worth 5 times the earth beads.
Also, note that in this problem, we are not dealing with decimals. So, the 9th column (1st
column from the right) represents the ones position, 8th the tens and so on.
Also, in the version of the abacus we are using, there is only one row of heaven beads,
and 4 rows of earth beads.
The task in this problem is quite easy: given the position of beads in the abacaus,
calculate the integer value represented.
Input Format
The 􀁾rst line of input consists of an integer t. This is the number of test cases.
Each test case consists of 2 lines of input. The 􀁾rst line of input contains 9 space
separated integers which are either 0 or 1,
second line contains 9 space separated integers which are either 0, 1, 2, 3 or 4.
Example
For example, suppose the two lines of input in a test case are:
This means that the beads in the heaven row in columns 1, 3, 4, 7 and 9 are in the
“down” position while two beads in the earth row in the 􀁾rst column are in the up
position,
1 bead in the 2nd column in the earth row in the up position and so on.
1 0 1 1 0 0 1 0 1
2 1 1 2 0 0 1 0 3

The output will an be integer value of the given orientation of beads.
For the example case above, because the beads in the heaven row are worth 5 times
the ones in the earth row, the integer displayed is 505500505+211200103 = 716700608
Constraints
0 < t < 1000 (This is the number of test cases)
0 < I < 10000000000 (size of the output integer)
Sample input :
2
1 0 1 1 0 0 1 0 1
2 1 1 2 0 0 1 0 3
0 1 0 1 1 0 1 0 1
2 2 1 4 0 3 1 3 4

Sample Output :
716700608
271953639

 * 
 */
package com.javaaid.ip.societe_generale;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

/**
 * @author Kanahaiya Gupta
 *
 */

public class Abacus {
	InputStream is;
	String INPUT = "";

	void solve() {
		for (int T = ni(); T > 0; T--) {
			long a = nl(true);
			long b = nl(false);
			System.out.println(a + b);
		}
	}

	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		solve();
	}

	public static void main(String[] args) throws Exception {
		new Abacus().run();
	}

	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl(boolean flag) {
		long num = 0;
		int b;
		int c = 0;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (isSpaceChar(b)) {
				if (c == 9)
					return minus ? -num : num;
			} else {
				if (!flag && b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
					c++;
				} else if (flag) {
					int tmp = b == '1' ? '5' : b;
					num = num * 10 + (tmp - '0');
					c++;
				} else {
					return minus ? -num : num;
				}
			}
			b = readByte();
		}
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

}
