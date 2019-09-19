package com.practice.graph.cyclic.undirected.disjointSets;

public class UndirectedGraphUtil {
	public static boolean isCyclic(Graph g) {
		int v = g.v;
		int e = g.e;
		Subset subsets[] = new Subset[v];
		
		for(int i = 0; i < v; ++i) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		for(int i = 0; i < e; ++i) {
			//FIND
			int x = DisjointSetUtil.find(g.edges[i].src, subsets);
			int y = DisjointSetUtil.find(g.edges[i].dest, subsets);
			
			if(x == y) {
				return true;
			}
			//UNION
			DisjointSetUtil.union(x, y, subsets);
		}
		return false;
	}
}
