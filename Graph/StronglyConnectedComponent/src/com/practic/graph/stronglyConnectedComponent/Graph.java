package com.practic.graph.stronglyConnectedComponent;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> adj[];
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void dfs(int u, boolean visited[]) {
		visited[u] = true;
		System.out.print(u + " ");
		
		for(int v : adj[u]) {
			if(visited[v] == false) {
				dfs(v, visited);
			}
		}
	}
}
