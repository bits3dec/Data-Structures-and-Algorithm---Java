package com.practice.graph.minimumSpanningTree;

public class Graph {
	int v;
	int e;
	Edge edges[];
	
	public Graph(int v, int e) {
		this.v = v;
		this.e = e;
		this.edges = new Edge[e];
		for(int i = 0; i < e; ++i) {
			this.edges[i] = new Edge();
		}
	}
}
