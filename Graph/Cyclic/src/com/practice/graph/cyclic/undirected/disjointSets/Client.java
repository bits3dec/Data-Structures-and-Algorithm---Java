package com.practice.graph.cyclic.undirected.disjointSets;

public class Client {
	public static void main(String[] args) {
        int v = 3, e = 3;
//      int v = 4, e = 3;
        Graph graph = new Graph(v, e);
        // add edge 0-1 
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        // add edge 1-2 
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;
        // add edge 0-2 
        graph.edges[2].src = 0;
        graph.edges[2].dest = 2; 
//        // add edge 1-3 
//        graph.edges[1].src = 1;
//        graph.edges[1].dest = 3;
        if (UndirectedGraphUtil.isCyclic(graph) == true)
           System.out.println("The graph contains cycle");
        else
            System.out.println("The graph doesnot contain cycle");
	}
}
