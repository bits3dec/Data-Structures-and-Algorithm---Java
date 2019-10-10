package com.practice.dp.lcs;

public class LCS {
	public static int longestCommonSubsequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		//t[i][j] denotes the longest common subsequence from str1[0...i] and str2[0...j]
		int t[][] = new int[m][n];
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(i == 0) {
					if(str1.charAt(0) == str2.charAt(j)) {
						t[i][j] = 1;
					}
				} else if(j == 0) {
					if(str2.charAt(0) == str1.charAt(i)) {
						t[i][j] = 1;
					}
				} else {
					if(str1.charAt(i) == str2.charAt(j)) {
						t[i][j] = 1 + t[i-1][j-1];
					} else {
						t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
					}
				}
			}
		}
		
		return t[m-1][n-1];
	}
}
