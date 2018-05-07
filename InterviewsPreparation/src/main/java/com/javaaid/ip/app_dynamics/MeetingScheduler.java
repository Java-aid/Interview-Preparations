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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Kanahaiya Gupta
 *
 */
class Time {
	private int inTime;
	private int outTime;

	public Time(int inTime, int outTime) {
		super();
		this.inTime = inTime;
		this.outTime = outTime;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

}

public class MeetingScheduler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Time> lists = new ArrayList<Time>();
		while (T-- > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int in = sc.nextInt();
				int out = sc.nextInt();
				Time slot = new Time(in, out);
				lists.add(slot);
			}
			int minRoomCount = getMinRoomCount(lists);
			System.out.println(minRoomCount);
		}

	}

	private static int getMinRoomCount(List<Time> lists) {
		int a[] = new int[25];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Time t : lists) {
			map.put(t.getOutTime(), -1);
		}
		for (Time interval : lists) {
			fillArray(interval, map, a);
		}
		int max = getMax(a);
		return max;
	}

	private static int getMax(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	private static void fillArray(Time interval, HashMap<Integer, Integer> map, int[] a) {
		int start = interval.getInTime();
		int end = interval.getOutTime();
		int i = 0;
		if (map.containsKey(start)) {
			i = start+1;
		} else {
			i = start;
		}
		for (; i <= end; i++) {
			a[i]++;
		}
	}

}
