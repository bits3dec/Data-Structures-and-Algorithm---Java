package com.practice.graph.shortestDistance;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//T:O(E*V)
public class BellmanFordAlgorithm {	
	int v;
	LinkedList<Integer> adj[];
	int weights[][];
	
	BellmanFordAlgorithm(Graph g) {
		this.v = g.v;
		this.adj = g.adj;
		this.weights = g.weights;
	}
	
	void shortestDistance(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int distances[] = new int[v];
		int paths[] = new int[v];
		for(int i = 0; i < v; ++i) {
			distances[i] = Integer.MAX_VALUE;
			paths[i] = -1;
		}
		
		queue.add(s);
		distances[s] = 0;
		paths[s] = s;
		
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			
			Iterator<Integer> it = adj[u].iterator();
			while(it.hasNext() == true) {
				int v = it.next();
				int newDistance = distances[u] + weights[u][v];
				if(newDistance < distances[v]) {
					distances[v] = newDistance;
					paths[v] = u;
					if(queue.contains(v) == false) {
						queue.add(v);
					}
				}
			}
		}
		
		print(s, distances, paths);
	} 
	
	private void print(int s, int distances[], int paths[]) {
		System.out.println("Source: " + s);
		for(int i = 0; i < v; ++i) {
			System.out.println("Vertex: " + i + " Distance: " + distances[i] + " Path: " + paths[i]);
		}
	}
}
