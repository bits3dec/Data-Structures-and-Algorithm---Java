package com.practice.graph.cyclic.undirected.bfs;

public class Client {
	public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        if (UndirectedGraphUtil.isCyclic(g) == true)
            System.out.println("DFS: The graph contains cycle");
        else
            System.out.println("DFS: The graph doesnot contain cycle");
	}
}
