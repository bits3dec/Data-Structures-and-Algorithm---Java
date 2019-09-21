package com.practice.graph.minimumSpanningTree;

import java.util.Arrays;

public class MinimumSpanningTree {

	public void kruskalsMST(Graph g) {
		int v = g.v;
		Edge res[] = new Edge[v-1];
		
		Arrays.sort(g.edges, (e1, e2) -> e1.weight - e2.weight);
		printEdges(g.edges, g.edges.length);
		
		Subset subsets[] = new Subset[v];
		for(int i = 0; i < v; ++i) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		int i = 0;
		int e = 0;
		int length = 0;
		while(e < v-1) {
			Edge nextEdge = g.edges[i];
			
			int x = find(nextEdge.src, subsets);
			int y = find(nextEdge.dest, subsets);
			
			if(x != y) {
				res[e] = nextEdge;
				++length;
				union(x, y, subsets);
				++e;
			}
			++i;
		}
		
		printEdges(res, length);
	}
	
	private int find(int x, Subset subsets[]) {
		if(subsets[x].parent == x) {
			return x;
		}
		return subsets[x].parent = find(subsets[x].parent, subsets);
	}
	
	private void union(int x, int y, Subset subsets[]) {
		int xRoot = find(x, subsets);
		int yRoot = find(y, subsets);
		
		if(subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else if (subsets[yRoot].rank > subsets[xRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}
	
	private void printEdges(Edge arr[], int length) {
		System.out.println("*** Edges ***");
		for(int i = 0; i < length; ++i) {
			System.out.println("Edges: " + arr[i].src + " ----- " + arr[i].dest + " || Weight: " + arr[i].weight);
		}
	}
}
