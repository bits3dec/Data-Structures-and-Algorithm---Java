package com.practice.dp.longestPalindromicSubsequence;

public class Client {
	public static void main(String[] args) {
		 String str = "AGCTCBMAACTGGAM";
		 
		 int res = LongestPalindromicSubsequence.lps(str);
		 System.out.println(res);
	}
}
