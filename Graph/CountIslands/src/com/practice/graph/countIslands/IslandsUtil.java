package com.practice.graph.countIslands;

public class IslandsUtil {
	private static final int rows[] = {-1, 0, 1, 1, 1, -1, -1, -1};
	private static final int cols[] = {1, 1, 1, 0, -1, 0, -1, 0};
	
	static int countIslands(int g[][], int m, int n) {
		boolean visited[][] = new boolean[m][n];
		int count = 0;
		
		for(int i = 0; i < m; ++ i) {
			for(int j = 0; j < n; ++j) {
				if(visited[i][j] == false && g[i][j] == 1) {
					dfs(i, j, g, m, n, visited);
					++count;
				}
			}
		}
		return count;
	}
	
	private static void dfs(int i, int j, int g[][], int m, int n, boolean visited[][])  {
		visited[i][j] = true;
		
		for(int k = 0; k < 8; ++k) {
			int row = rows[k] + i;
			int col = cols[k] + j;
			if(isValid(row, col, m, n) == true && visited[row][col] == false && g[row][col] == 1) {
				dfs(row, col, g, m, n, visited);
			}
		}
	}
	
	private static boolean isValid(int x, int y, int m, int n) {
		if(x < 0 || y < 0 || x >= m || y >= n) {
			return false;
		}
		return true;
	}
}
