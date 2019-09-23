package com.practice.graph.shortestDistance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//Set<Integer> settled: Processed nodes(shortest path found)
//Heap heap(Priority queue): Non processed nodes(still in progress to find the shortest path)
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
		Arrays.fill(paths,-1);
		
		//Visited nodes
		Set<Integer> settled = new HashSet<Integer>();
		//Priority Queue
		Heap heap = new Heap(v);
		
		//Source
		Node node = new Node(src, 0);
		heap.insert(node);
		distances[src] = 0;
		paths[src] = -1;
		
		//Process till all the nodes are calculated with the shortest distance
		while(settled.size() != v) {
			//Get the minimum distance adjacent node from the unvisited nodes using priority queue
			Node temp = heap.deleteMin();
			int u = temp.value;
			int distance = temp.distance;
			//add it to visited nodes
			settled.add(u);
			
			//Calculate adjacent nodes distance for the current node and add it to priority queue
			for(int v : adj[u]) {
				//Process only non-processed nodes
				if(settled.contains(v) == false) {
					int newDistance = distance + weights[u][v];
					if(newDistance < distances[v]) {
						//update the new minimum distance and path
						distances[v] = newDistance;
						paths[v] = u;
					}
					node = new Node(v, distances[v]);
					//Note- We are not updating the old node if already present.
					//We are adding a new node in heap with the updated distance
					heap.insert(node);
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
