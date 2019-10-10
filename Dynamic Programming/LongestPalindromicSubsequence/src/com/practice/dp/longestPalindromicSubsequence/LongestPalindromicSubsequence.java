package com.practice.dp.longestPalindromicSubsequence;

public class LongestPalindromicSubsequence {
	public static int lps(String str) {
		int n = str.length();
		
		//t[i][j] denotes the longest palindromic subsequence from str[i...j]
		int t[][] = new int[n][n];
		
		for(int i = 0; i < n; ++i) {
			t[i][i] = 1;
		}
		
		for(int i = 0; i < n-1; ++i) {
			if(str.charAt(i) == str.charAt(i+1)) {
				t[i][i+1] = 2;
			} else {
				t[i][i+1] = 1;
			}
		}
		
		for(int l = 3; l <= n; ++l) {
			for(int i = 0; i <= n-l; ++i) {
				int j = i + l -1;
				if(str.charAt(i) == str.charAt(j)) {
					t[i][j] = t[i+1][j-1] + 2;
				} else {
					t[i][j] = Math.max(t[i+1][j], t[i][j-1]);
				}
			}
		}
		return t[0][n-1];
	}
}
