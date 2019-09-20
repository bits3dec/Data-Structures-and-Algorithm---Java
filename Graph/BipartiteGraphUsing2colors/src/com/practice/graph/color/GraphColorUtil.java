package com.practice.graph.color;
import java.util.LinkedList;
import java.util.Queue;

public class GraphColorUtil {
	private static int v;
	private static LinkedList<Integer> adj[];
	
	public static boolean isBipartite(Graph g) {
		v = g.v;
		adj = g.adj;
		
		int colors[] = new int[v];
		for(int i = 0; i < v; ++i) {
			colors[i] = -1;
		}
		
		int s = 0;
		if(coloringUtil(s, colors) == true) {
			return true;
		}
		return false;
	}
	
	private static boolean coloringUtil(int s, int colors[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		colors[s] = 1;
		
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			
			for(int v : adj[u]) {
				if(colors[v] == -1) {
					queue.add(v);
					colors[v] = 1 - colors[u];
				} else {
					if(colors[v] == colors[u]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
