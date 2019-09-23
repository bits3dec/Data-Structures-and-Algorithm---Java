package com.practice.graph.shortestDistance;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> adj[];
	int weights[][];
	
	public Graph(int v, int weights[][]) {
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
		this.weights = weights;
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
}
