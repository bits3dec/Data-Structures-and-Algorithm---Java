package com.practice.graph.cyclic.undirected.dfs;

import java.util.LinkedList;

public class UndirectedGraphUtil {
	static int v;
	static LinkedList<Integer> adj[];
	
	public static boolean isCyclic(Graph g) {
		v = g.v;
		adj = g.adj;
		boolean visited[] = new boolean[v];
		int parent = -1;
		
		for(int i = 0; i < v; ++i) {
			if(visited[i] == false && isCyclicUtil(i, visited, parent) == true) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCyclicUtil(int u, boolean visited[], int parent) {
		visited[u] = true;
		
		for(int v : adj[u]) {
			if(visited[v] == false) {
				if(isCyclicUtil(v, visited, u) == true) {
					return true;
				}
			} else if(v != parent) {
				return true;
			}
		}
		return false;
	}
}
