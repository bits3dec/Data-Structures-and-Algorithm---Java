package com.practice.graph.topologicalSort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortDFS {
	int v;
	LinkedList<Integer> adj[];
	
	void topologicalSort(Graph g) {
		int v = g.v;
		adj = g.adj;
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[v];
		
		for(int i = 0; i < v; ++i) {
			if(visited[i] == false) {
				dfsUtil(i, visited, stack);
			}
		}
		
		print(stack);
	}
	
	private void dfsUtil(int u, boolean visited[], Stack stack) {
		visited[u] = true;
		
		Iterator<Integer> it = adj[u].iterator();
		while(it.hasNext() == true) {
			int v = it.next();
			if(visited[v] == false) {
				dfsUtil(v, visited, stack);
			}
		}
		
		stack.push(u);
	}
	
	private void print(Stack<Integer> stack) {
		while(stack.isEmpty() == false) {
			int v = stack.pop();
			System.out.println(v);
		}
	}
}
