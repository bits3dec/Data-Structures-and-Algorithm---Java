package com.practice.graph.shortestDistance;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> adj[];
	int weights[][];
	
	Graph(int v, int weights[][]) {
		this.v = v;
		this.weights = weights;		
		this.adj = new LinkedList[v];
		for(int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
}
