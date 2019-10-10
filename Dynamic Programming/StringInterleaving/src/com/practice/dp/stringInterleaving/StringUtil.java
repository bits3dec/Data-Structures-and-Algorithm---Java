package com.practice.dp.stringInterleaving;

public class StringUtil {
	public static boolean isInterleaving(String s1, String s2, String s3) {
		int m = s1.length();
		int n = s2.length();
		int l = s3.length();

		if (l != m + n) {
			return false;
		}

		// T[i][j] denotes if s3[0...i+j-1] is formed by the interleaving of s1[0...i-1] and s2[0...j-1]	
		boolean t[][] = new boolean[m + 1][n + 1];

		for (int i = 0; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				if (i == 0 && j == 0) {
					t[i][j] = true;
				} else if (i == 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					t[i][j] = t[i][j - 1];
				} else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					t[i][j] = t[i - 1][j];
				}
				if (i == 0 || j == 0) {
					continue;
				}

				if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
					t[i][j] = t[i - 1][j];
				} else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && s1.charAt(i - 1) != s3.charAt(i + j - 1)) {
					t[i][j] = t[i][j - 1];
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					t[i][j] = t[i - 1][j] || t[i][j - 1];
				}
			}
		}

		return t[m][n];
	}
}
