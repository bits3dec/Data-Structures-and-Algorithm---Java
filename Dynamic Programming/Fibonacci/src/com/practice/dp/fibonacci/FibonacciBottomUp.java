package com.practice.dp.fibonacci;

public class FibonacciBottomUp {
	private static int fib[];
	public static int printFibonacciBottomUp(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		fib = new int[n];
		fib[0] = 1;
		fib[1] = 1;		
		for(int i = 2; i < n; ++i) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n-1];
	}
}
