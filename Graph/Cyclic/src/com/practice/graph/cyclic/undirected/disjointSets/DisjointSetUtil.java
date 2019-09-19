package com.practice.graph.cyclic.undirected.disjointSets;

public class DisjointSetUtil {
	//Path Compression
	public static int find(int x, Subset subsets[]) {
		if(subsets[x].parent == x) {
			return x;
		}
		return subsets[x].parent = find(subsets[x].parent, subsets);
	}
	
	//Union By Rank
	public static void union (int x, int y, Subset subsets[]) {
		int xRoot = find(x, subsets);
		int yRoot = find(y, subsets);
		
		if(subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else if(subsets[yRoot].rank > subsets[xRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}
}
