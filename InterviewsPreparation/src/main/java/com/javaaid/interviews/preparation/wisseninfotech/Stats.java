/**
 * 
 */
package com.javaaid.interviews.preparation.wisseninfotech;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Kanahaiya Gupta
 *
 */

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		ConcurrentHashMap<String, ArrayList<Double>> map=new ConcurrentHashMap<String,ArrayList<Double>>();
		ArrayList list=null;
		volatile int  count=0;
		@Override
		public synchronized  void  putNewPrice(String symbol, double price) {
			// YOUR CODE HERE
			if(map.containsKey(symbol)) {
				 list=map.get(symbol);
			}else {
				list=new ArrayList<Double>();
			}
			 list.add(price);
			 map.put(symbol, list);

		}

		@Override
		public synchronized  double getAveragePrice(String symbol) {
			ArrayList<Double> tmp=map.get(symbol);
			 count=tmp.size();
			Double price=0.0;
			for(Double d:map.get(symbol)) {
				price+=d;
			}
			return price/count;
			// YOUR CODE HERE
		}

		@Override
		public synchronized  int   getTickCount(String symbol) {
			return count;
			// YOUR CODE HERE
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}