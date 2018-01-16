/**
 * 
 */
package com.javaaid.interviews.preparation.spraoi;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kanahaiya Gupta
 *
 */
public class CoinChange {
	public static void main(String[] args) {
	    Integer actual = CoinChange.countChange(4,Arrays.asList(1,2));
	    System.out.println(actual);
	}
	 public static Integer countChange( Integer money,List<Integer> coins ) {
		 int noOfcoins=coins.size();
		return countNumberOfWays(coins,noOfcoins,money);
	  }
	/**
	 * @param coins
	 * @param noOfcoins
	 * @param money
	 * @return
	 */
	private static Integer countNumberOfWays(List<Integer> coins, int noOfcoins, Integer money) {
		if(money==0)return 1;
		if(money<0)return 0;
		if(noOfcoins<=0 && money>=1)return 0;
		return countNumberOfWays(coins,noOfcoins-1,money)+countNumberOfWays(coins,noOfcoins,money-coins.get(noOfcoins-1));
	}


}
