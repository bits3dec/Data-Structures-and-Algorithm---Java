package com.practice.graph.boggle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Boggle {
	private static int rows[] = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
	private static int cols[] = new int[] {1, 1, 1, 0, -1, -1, -1, 0};
		
	//DFS
	public static void findWords(char boggle[][], Set<String> lookup) {
		int m = boggle.length;
		int n = boggle[0].length;
		boolean visited[][] = new boolean[m][n];
		String str = "";
		Set<String> foundWords = new HashSet<String>();
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				findWordsUtil(i, j, str, visited, boggle, lookup, foundWords);
			}
		}
		print(foundWords);
	}
	
	private static void findWordsUtil(int i, int j, String str, boolean visited[][], char boggle[][], Set<String> lookup, Set<String> foundWords) {
		visited[i][j] = true;
		str += boggle[i][j];
		
		if(lookup.contains(str) == true) {
			foundWords.add(str);
		}
		
		int n = rows.length;//8
		for(int k = 0; k < n; ++k) {
			int row = i + rows[k];
			int col = j + cols[k];
			
			if(isValid(row, col, boggle) == true && visited[row][col] == false) {
				findWordsUtil(row, col, str, visited, boggle, lookup, foundWords);
			}
		}
		visited[i][j] = false;
	}
	
	private static boolean isValid(int i, int j, char boggle[][]) {
		int m = boggle.length;
		int n = boggle[0].length;
		
		if(i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		return true;
	}
	
	private static void print(Set<String> foundWords) {
		Iterator<String> it = foundWords.iterator();
		while(it.hasNext() == true) {
			String str = it.next();
			System.out.println(str);
		}
	}
}
