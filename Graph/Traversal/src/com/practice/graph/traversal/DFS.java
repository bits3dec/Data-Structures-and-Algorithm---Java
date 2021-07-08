package com.practice.graph.traversal;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	int v;
	LinkedList<Integer> adj[];
	
	public DFS(Graph g) {
		this.v = g.v;
		this.adj = g.adj;
	}
	
	public void dfs(int s) {
		boolean visited[] = new boolean[v];
		dfsUtil(s, visited);	
 	}
	
	private void dfsUtil(int u, boolean visited[]) {	
		visited[u] = true;
		System.out.println(u);
		
	    Iterator<Integer> it = adj[u].listIterator();
		while(it.hasNext() == true) {
			int v = it.next();
			if(visited[v] == false) {
				dfsUtil(v, visited);
			}
		}
	}
}
