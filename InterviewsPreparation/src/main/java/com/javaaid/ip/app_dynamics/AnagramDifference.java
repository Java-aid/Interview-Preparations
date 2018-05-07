/**
 * 
 */
package com.javaaid.ip.app_dynamics;

import java.util.Scanner;

/**
 * @author Kanahaiya Gupta
 *
 */
public class AnagramDifference {
	
			public static void main(String[] args) {
				AnagramDifference s=new AnagramDifference();
				Scanner in = new Scanner(System.in);
				String[] a = {"a","jk","abb","mn","abc"} ;
				String[] b = {"bb","kj","bbc","op","def"};
					 s.getMinimumDifference(a,b);
				}
			
			private  int[] getMinimumDifference(String[] a, String[] b) {
				int n=a.length;
				int ans[]=new int[n];
				for(int i=0;i<n;i++) {
					String s1=a[i];
					String s2=b[i];
					int result=getAnagramDiff(s1,s2);
					ans[i]=result;
//				System.out.println(result);
			}
				return ans;
			}
	  int getAnagramDiff(String s1, String s2)
		    {
		        int count = 0;
		        int s1len=s1.length();
		        int s2len=s2.length();
		        if(s1len!=s2len)return-1;
		        int char_count[] = new int[26];
		 
		        for (int i = 0; i < s1.length(); i++) 
		            char_count[s1.charAt(i) - 'a']++;        
		        for (int i = 0; i < s2.length(); i++) 
		            if (char_count[s2.charAt(i) - 'a']-- <= 0)
		                count++;
		         
		        return count;
		    }
	 }