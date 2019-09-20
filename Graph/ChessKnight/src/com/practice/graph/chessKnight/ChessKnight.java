package com.practice.graph.chessKnight;

import java.util.LinkedList;
import java.util.Queue;

public class ChessKnight {
	private final int rows[] = {2, 2, 1, -1, -2, -2, -1, 1};
	private final int cols[] = {-1, 1, 2, 2, 1, -1, -2, -2};
	private final Cell source;
	private final Cell dest;
	private final int n;
	
	public ChessKnight(int startingX, int startingY, int endingX, int endingY, int n) {
		this.source = new Cell(startingX, startingY);
		this.dest = new Cell(endingX, endingY);
		this.n = n;
	}
	
	int getMinSteps() {
		boolean visited[][] = new boolean[n][n];
		Queue<Cell> queue = new LinkedList<Cell>();
		queue.add(source);
		visited[source.x][source.y] = true;
		int minSteps = 0;
		
		while(queue.isEmpty() == false) {
			Cell temp = queue.poll();
			if(temp.x == dest.x && temp.y == dest.y) {
				minSteps = temp.dist;
				break;
			}
			
			for(int j = 0; j < 8; ++j) {
				int row = rows[j] + temp.x;
				int col = cols[j] + temp.y;
				
				if(isValid(row, col) == true && visited[row][col] == false) {
					Cell cell = new Cell(row, col);
					cell.dist = temp.dist + 1;
					queue.add(cell);
					visited[row][col] = true;
				}
			}
		}
		return minSteps;
	}
	
	private boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n) {
			return false;
		}
		return true;
	}
	
	class Cell {
		int x;
		int y;
		int dist;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
