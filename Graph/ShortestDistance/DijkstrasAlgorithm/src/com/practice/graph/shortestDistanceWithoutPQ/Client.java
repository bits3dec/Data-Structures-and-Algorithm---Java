package com.practice.graph.shortestDistanceWithoutPQ;

public class Client {
	public static void main(String[] args) {
		int weights[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
										{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
									    { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									    { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									    { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
									    { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									    { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									    { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
									    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
									   };
		Graph g = new Graph(9, weights);
		g.addEdge(0, 1);
		g.addEdge(0, 7);
		g.addEdge(1, 2);
		g.addEdge(1, 7);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(2, 8);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		g.addEdge(7, 8);
		
		DijkstrasAlgorithm test = new DijkstrasAlgorithm();
		test.shortestDistance(0, g);
	}
}
