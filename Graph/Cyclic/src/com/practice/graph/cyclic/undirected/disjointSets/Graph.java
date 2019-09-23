package com.practice.graph.cyclic.undirected.disjointSets;

public class Graph {
	 int v;
     int e;
     Edge[] edges;

     Graph(int v, int e)
     {
         this.v = v;
         this.e = e;
         this.edges = new Edge[e];
         for (int i = 0; i < e; ++i)
             edges[i] = new Edge();
     }
	
	class Edge {
		int src;
		int dest;
	}
}