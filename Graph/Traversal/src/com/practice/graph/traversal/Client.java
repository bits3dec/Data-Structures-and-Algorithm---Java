package com.practice.graph.traversal;

public class Client {
	public static void main(String[] args) {

        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);
        
        System.out.println("The Depth First Traversal of the given graph is:");       
        DFS dfsTraversal = new DFS(graph1);
        dfsTraversal.dfs(2);
        
        System.out.println("The Breadth First Traversal of the given graph is:");
        BFS bfsTraversal = new BFS(graph1);
        bfsTraversal.bfs(2);
	}
}
