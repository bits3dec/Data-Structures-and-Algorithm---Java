package com.practice.graph.cyclic.undirected.disjointSets;

import java.util.LinkedList;

public class Graph {
	
	 int v;
     int e;
     Edge[] edges;

     Graph(int v, int e)
     {
         this.v = v;
         this.e = e;
         edges = new Edge[e];
         for (int i = 0; i < e; ++i)
             edges[i] = new Edge();
     }
	
	class Edge {
		int src;
		int dest;
	}
}