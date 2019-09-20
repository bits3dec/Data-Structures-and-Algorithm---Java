package com.practice.graph.color;

import java.util.LinkedList;

public class GraphColorUtil {
	private static int v;
	private static LinkedList<Integer> adj[];
	
	public static boolean coloring(Graph g, int m) {
		v = g.v;
		adj = g.adj;
		
		int colors[] = new int[v];
		for(int i = 0; i < v; ++i) {
			colors[i] = -1;
		}
		
		int s = 0;
		if(coloringUtil(s, m, colors) == true) {
			System.out.println("Graph can be colored with " + m + " colors");
			printColors(colors);
			return true;
		} 
		System.out.println("Graph cannot be colored with " + m + " colors");
		return false;
	}
	
	//Similar to DFS
	private static boolean coloringUtil(int u, int m, int colors[]) {
		if(u == v) {
			return true;//If all vertices are assigned colors then return true
		}
		
		for(int c = 1; c <= m; ++c) {
			if(isSafe(u, c, colors) == true) {
				colors[u] = c;
				if(coloringUtil(u+1, m, colors) == true) {
					return true;
				}
				colors[u] = -1;//If assigning the color doesnot lead to a solution then remove it
			}
		}
		return false;
	}
	
	private static boolean isSafe(int u, int c, int colors[]) {
		for(int v : adj[u]) {
			if(colors[v] == c) {
				return false;
			}
		}
		return true;
	}
	
	 private static void printColors(int[] colors)
     {
         for(int i = 0; i < v; ++i)
             System.out.print(colors[i] + " ");
     }
}
