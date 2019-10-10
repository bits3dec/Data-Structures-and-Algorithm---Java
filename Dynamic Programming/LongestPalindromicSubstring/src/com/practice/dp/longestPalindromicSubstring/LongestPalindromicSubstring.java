package com.practice.dp.longestPalindromicSubstring;

public class LongestPalindromicSubstring {
	public static int lps(String str) {
		int n = str.length();
		
		//t[i][j] denotes if str[i..j] is a palindrome
		boolean t[][] = new boolean[n][n];
		int maxLength = -1;
		int startIndex = -1;
		
		for(int i = 0; i < n; ++i) {
			t[i][i] = true;
			maxLength = 1;
			startIndex = i;
		}
		for(int i = 0; i < n-1; ++i) {
			if(str.charAt(i) == str.charAt(i+1)) {
				t[i][i+1] = true;
				maxLength = 2;
				startIndex = i;
			}
		}
		for(int l = 3; l <= n; ++l) {
			for(int i = 0; i <= n-l; ++i) {
				int j = i + l - 1;
				if(str.charAt(i) == str.charAt(j) && t[i+1][j-1] == true) {
					t[i][j] = true;
					if(l > maxLength) {
						maxLength = l;
						startIndex = i;
					}
				}
			}
		}
		
		return maxLength;
	}
}
