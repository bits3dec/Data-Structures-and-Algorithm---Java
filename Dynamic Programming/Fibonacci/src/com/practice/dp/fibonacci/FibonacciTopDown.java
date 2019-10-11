package com.practice.dp.fibonacci;

public class FibonacciTopDown {
	private static int fib[];
	public static int printFibonacciTopDown(int n) {
		fib = new int[n+1];		
		return printFibonacciTopDownUtil(n);
	}
	
	private static int printFibonacciTopDownUtil(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		if(fib[n] != 0) {
			return fib[n];
		}
		return fib[n] = printFibonacciTopDownUtil(n-1) + printFibonacciTopDownUtil(n-2);
	}
}
