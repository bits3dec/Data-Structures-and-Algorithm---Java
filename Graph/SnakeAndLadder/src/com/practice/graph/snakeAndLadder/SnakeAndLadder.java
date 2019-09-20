package com.practice.graph.snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
	int moves[];
	int n;
	
	public SnakeAndLadder(int moves[], int n) {
		this.moves = moves;
		this.n = n;
	}

	int getMinThrows(int start) {
		boolean visited[] = new boolean[n];
		Queue<Cell> queue = new LinkedList<Cell>();
		
		Cell source = new Cell();
		queue.add(source);
		visited[start] = true;		
		int minThrows = Integer.MAX_VALUE;
		
		while(queue.isEmpty() == false) {
			Cell temp = queue.poll();
			
			if(temp.v == n-1) {
				minThrows = temp.dist;
				break;
			}
			
			for(int j = 1; j <= 6; ++j) {
				int v = temp.v + j;
				if(v >= n) {
					break;
				}
				
				if(visited[v] == false) {
					Cell cell = new Cell();
					if(moves[v] != -1) {
						cell.v = moves[v];
						cell.dist = temp.dist + 1;
					} else {
						cell.v = v;
						cell.dist = temp.dist + 1;
					}
					queue.add(cell);
					visited[v] = true;
				}		
 			}
		}
		return minThrows;
	}
	
	class Cell {
		int v;
		int dist;
	}
}
