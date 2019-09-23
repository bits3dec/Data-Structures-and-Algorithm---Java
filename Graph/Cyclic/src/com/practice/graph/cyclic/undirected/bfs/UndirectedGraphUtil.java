package com.practice.graph.cyclic.undirected.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphUtil {
	static int v;
	static LinkedList<Integer> adj[];
	
	public static boolean isCyclic(Graph g) {
		v = g.v;
		adj = g.adj;
		
		boolean visited[] = new boolean[v];
		int parents[] = new int[v];
		
		for(int i = 0; i < v; ++i) {
			parents[i] = -1;
		}
		
		for(int i = 0; i < v; ++i) {
			if(visited[i] == false && isCyclicUtil(i, visited, parents) == true) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCyclicUtil(int s, boolean visited[], int parents[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			
			for(int v : adj[u]) {
				if(visited[v] == false) {
					queue.add(v);
					parents[v] = u;
					visited[v] = true;
				} else if(v != parents[u]) {
					return true;
				}
			}
		}
		return false;
		
	}
}
