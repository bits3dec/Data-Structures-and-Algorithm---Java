package com.practice.dp.stringInterleaving;

public class Client {
	public static void main(String[] args) {
		 boolean res = false;	 
		 res = StringUtil.isInterleaving("XXY", "XXZ", "XXZXXXY");
		 System.out.println(res);
		 res = StringUtil.isInterleaving("XY", "WZ", "WZXY"); 
		 System.out.println(res);
		 res = StringUtil.isInterleaving("XY", "X", "XXY");
		 System.out.println(res);
		 res = StringUtil.isInterleaving("YX", "X", "XXY");
		 System.out.println(res);
		 res = StringUtil.isInterleaving("XXY", "XXZ", "XXXXZY"); 
		 System.out.println(res);
	}
}
