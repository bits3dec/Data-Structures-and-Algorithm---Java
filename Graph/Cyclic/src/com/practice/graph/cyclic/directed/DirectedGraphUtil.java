package com.practice.graph.cyclic.directed;

import java.util.LinkedList;

public class DirectedGraphUtil {
	static int v;
	static LinkedList<Integer> adj[];
	
	public static boolean isCyclic(Graph g) {
		v = g.v;
		adj = g.adj;
		boolean visited[] = new boolean[v];
		boolean recursionStack[] = new boolean[v];
		
		for(int i = 0;i < v; ++i) {
			if(visited[i] == false && isCyclicUtil(i, visited, recursionStack) == true) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCyclicUtil(int u, boolean visited[], boolean recursionStack[]) {
		visited[u] = true;
		recursionStack[u] = true;

		for(int v : adj[u]) {
			if(visited[v] == false) {
				if(isCyclicUtil(v, visited, recursionStack) == true) {
					return true;
				}
			} else if(recursionStack[v] == true) {
				return true;
			}
		}
		recursionStack[u] = false;
		
		return false;
	}
}
