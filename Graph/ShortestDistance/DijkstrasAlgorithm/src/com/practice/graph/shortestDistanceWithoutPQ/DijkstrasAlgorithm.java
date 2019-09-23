package com.practice.graph.shortestDistanceWithoutPQ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//T:O(E*log(V))
//Set<Integer> settled: Processed nodes(shortest path found)
//NodeCollection: Non processed nodes(still in progress to find the shortest path)
//Note- DijkstrasAlgorithm will not work for negative edges
public class DijkstrasAlgorithm {
	int v;
	LinkedList<Integer> adj[];
	int weights[][];
	
	public void shortestDistance(int src, Graph g) {
		this.v = g.v;
		this.adj = g.adj;
		this.weights = g.weights;
		
		int distances[] = new int[v];
		int paths[] = new int[v];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(paths, -1);
		
		//Settled set
		Set<Integer> settled = new HashSet<Integer>();
		//Unsettled set
		NodeCollection unsettled = new NodeCollection();
		
		//Add all nodes to the unsettled set
		for(int i = 0; i < v; ++i) {
			unsettled.insert(i, Integer.MAX_VALUE);
		}
		
		distances[src] = 0;
		paths[src] = -1;
		//update the source in the unsettled set with initial values
		unsettled.insert(src, distances[src]);
		
		//Process till the settled set contains all the nodes
		while(settled.size() != v) {
			int u = unsettled.deleteMin();
			//Add the node to the settled set
			settled.add(u);
			
			for(int v : adj[u]) {
				//Check shortest distance for only unsettled nodes
				if(settled.contains(v) == false) {
					int newDistance = distances[u] + weights[u][v];
					if(newDistance < distances[v]) {
						distances[v] = newDistance;
						paths[v] = u;					
					}
					//Insert or update the node in unsettled set
					unsettled.insert(v, distances[v]);
				}
			}
		}	
		print(src, distances, paths);
	}
	
	private void print(int src, int distances[], int paths[]) {
		System.out.println("Shortest distance for all nodes from source: " + src);
		
		for(int i = 0; i < v; ++i) {
			System.out.print("Vertex: " + i + " Path: " + paths[i] + " Distance: " + distances[i] + "\n");
		}
	}
}
