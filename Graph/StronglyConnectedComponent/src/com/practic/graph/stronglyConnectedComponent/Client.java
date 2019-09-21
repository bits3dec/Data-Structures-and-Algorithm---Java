package com.practic.graph.stronglyConnectedComponent;

public class Client {
	public static void main(String[] args) {
		StronglyConnectedComponent test = new StronglyConnectedComponent();

		Graph graph = new Graph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);

		System.out.println("Following are the strongly connected components in the given graph:");
		test.printSCCs(graph);
	}
}
