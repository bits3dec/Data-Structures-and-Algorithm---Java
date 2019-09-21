package com.practice.graph.eulerian;

import java.util.Iterator;
import java.util.LinkedList;

public class Eulerian {
	private int v;
	private LinkedList<Integer> adj[];
	
	public void checkEulerian(Graph g) {
		this.v = g.v;
		this.adj = g.adj;
		
		if(isConnected() == false) {
			System.out.println("Graph is not connected !!!");
			return;
		}
		
		int odd = 0;		
		for(int i = 0; i < v; ++i) {
			if(adj[i].size() % 2 == 1) {
				++odd;
				if(odd > 2) {
					break;
				}
			}
		}
		
		if(odd == 0) {
			System.out.println("Graph is Eulerian (Eulerian circuit/cycle) !!!");
			return;
		} else if(odd == 2) {
			System.out.println("Graph is Semi-Eulerian (Eulerian path exists) !!!");
			return;
		} else {
			System.out.println("Graph is not eulerian !!!");
			return;
		}
	}
	
	private boolean isConnected() {
		int i = 0;
		//find a non-zero degree vertex
		for(i = 0; i < v; ++i) {
			if(adj[i].size() > 0) {
				break;
			}
		}
		//if all the vertices are zero degree vertices then there are no edges. Hence return true since we consider only edges for eulerian
		if(i == v) {
			return true;
		}
		
		boolean visited[] = new boolean[v];
		dfs(i, visited);
		
		//check if all non-zero degree vertices are traversed
		for(i = 0; i < v; ++i) {
			if(visited[i] == false && adj[i].size() > 0) {
				return false;
			}
		}
		return true;
	}
	
	private void dfs(int u, boolean visited[]) {
		visited[u] = true;
		
		Iterator<Integer> it = adj[u].iterator();
		while(it.hasNext() == true) {
			int v = it.next();
			if(visited[v] == false) {
				dfs(v, visited);
			}
		}
	}
}
