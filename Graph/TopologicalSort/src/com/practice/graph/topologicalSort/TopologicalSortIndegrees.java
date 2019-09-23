package com.practice.graph.topologicalSort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortIndegrees {
	
	void topologicalSort(Graph g) {
		int v = g.v;
		LinkedList<Integer> adj[] = g.adj;
		int topologicalOrder[] = new int[v];
		
		int indegrees[] = new int[v];
		for(int i = 0; i < v; ++i) {
			Iterator<Integer> it = adj[i].iterator();
			while(it.hasNext() == true) {
				int w = it.next();
				indegrees[w]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < v; ++i) {
			if(indegrees[i] == 0) {
				queue.add(i);
			}
		}
		
		int count = 0;
		while(queue.isEmpty() == false) {
			int u = queue.poll();
			topologicalOrder[count] = u;
			++count;
			
			Iterator<Integer> it = adj[u].iterator();
			while(it.hasNext() == true) {
				int w = it.next();
				if(--indegrees[w] == 0) {
					queue.add(w);
				}
			}
		}
		
		if(count == v) {
			print(topologicalOrder);
		} else {
			System.out.println("Graph has cycle !!!");
		}
	}
	
	private void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
	}
}
