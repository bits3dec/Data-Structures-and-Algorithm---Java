package com.practice.graph.cyclic.directed;

public class Client {
	public static void main(String[] args) {
	    Graph graph = new Graph(4);
	    graph.addEdge(0, 1);
	    graph.addEdge(0, 2);
	    graph.addEdge(1, 2);
	    graph.addEdge(2, 0);
	    graph.addEdge(2, 3);
	    graph.addEdge(3, 3);
	    if(DirectedGraphUtil.isCyclic(graph) == true)
	        System.out.println("The graph contains cycle");
	    else
	        System.out.println("The graph doesnot contain cycle");
	}
	
}
