package com.practice.dp.longestPalindromicSubstring;

public class Client {
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		
		int res = LongestPalindromicSubstring.lps(str);
		System.out.println(res);
	}
}
