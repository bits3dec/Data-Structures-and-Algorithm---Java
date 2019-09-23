package com.practice.graph.cyclic.undirected.bfs;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> adj[];
	
	Graph(int v) {
		this.v = v;	
		this.adj = new LinkedList[v];
		for(int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
}