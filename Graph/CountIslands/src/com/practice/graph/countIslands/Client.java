package com.practice.graph.countIslands;

public class Client {
	public static void main(String[] args) {
		int[][] g = new int[][] {{1, 1, 0, 0, 0},
                				{0, 1, 0, 0, 1},
                				{1, 0, 0, 1, 1},
                				{0, 0, 0, 0, 0},
                				{1, 0, 1, 0, 1}};
        int m = 5;
        int n = 5;
        System.out.println("Number of islands is: " + IslandsUtil.countIslands(g, m, n));
	}
}
