package com.practice.dp.lcs;

public class Client {
	public static void main(String[] args) {
		String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        
        int lcs = LCS.longestCommonSubsequence(str1, str2);
        System.out.println(lcs);
	}
}
