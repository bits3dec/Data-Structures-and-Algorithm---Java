package com.practic.graph.stronglyConnectedComponent;

import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponent {
	int v;
	LinkedList<Integer> adj[];
	
	public void printSCCs(Graph g) {
		this.v = g.v;
		this.adj = g.adj;
		
		boolean visited[] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < v; ++i) {
			if(visited[i] == false) {
				fillOrder(i, visited, stack);
			}
		}

		Graph gT = getTranspose(g);
		
		resetVisited(visited);
		
		while(stack.isEmpty() == false) {
			int u = stack.pop();
			if(visited[u] == false) {
				gT.dfs(u, visited);
				System.out.println();
			}
		}
	}
	
	private void fillOrder(int u, boolean visited[], Stack<Integer> stack) {
		visited[u] = true;
		
		for(int v : adj[u]) {
			if(visited[v] == false) {
				fillOrder(v, visited, stack);
			}
		}
		stack.push(u);
	}
	
	private Graph getTranspose(Graph g) {
		Graph gT = new Graph(v);
		for(int u = 0; u < v; ++u) {
			for(int v : adj[u]) {
				gT.adj[v].add(u);
				//gT.addEdge(v, u);
			}
		}
		return gT;
	}
		
	private void resetVisited(boolean visited[]) {
		for(int i = 0; i < v; ++i) {
			visited[i] = false;
		}
	}
}
