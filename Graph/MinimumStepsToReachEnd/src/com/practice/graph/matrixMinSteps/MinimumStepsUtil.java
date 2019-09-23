package com.practice.graph.matrixMinSteps;

import java.util.*;

public class MinimumStepsUtil {
	public static int getMinSteps(int arr[][]) {
	    int n = arr.length;
	    Cell src = new Cell(0, 0, 0);
	    Cell dest = new Cell(n-1, n-1, Integer.MAX_VALUE);
	    boolean visited[][] = new boolean[n][n];
	    
	    Queue<Cell> queue = new LinkedList<Cell>();
	    queue.add(src);
	    visited[0][0] = true;
	    int minSteps = Integer.MAX_VALUE;
	    
	    while(queue.isEmpty() == false) {
	        Cell temp = queue.poll();
	        
	        if(temp.x == dest.x && temp.y == dest.y) {
	            minSteps = temp.steps;
	            break;
	        }
	        
	        int row = 0;
	        int col = 0;
	        int steps = 0;
	        
	        Cell cell = null;
	        row = temp.x + arr[temp.x][temp.y];
	        col = temp.y;
	        steps = temp.steps + 1;
	        if(isValid(row, col, n) == true && visited[row][col] == false) {
	            cell = new Cell(row, col, steps);
	            queue.add(cell);
	            visited[row][col] = true;
	        }
	        
	        row = temp.x;
	        col = temp.y + arr[temp.x][temp.y];
	        steps = temp.steps + 1;
	        if(isValid(row, col, n) == true && visited[row][col] == false) {
	            cell = new Cell(row, col, steps);
	            queue.add(cell);
	            visited[row][col] = true;
	        }
	    }
	    return minSteps;
	}
	
	private static boolean isValid(int x, int y, int n) {
	    if(x < 0 || y < 0 || x >= n || y >= n) {
	        return false;
	    }
	    return true;
	}
}
