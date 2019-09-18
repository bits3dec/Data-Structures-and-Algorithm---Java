package com.practice.graph.shortestDistance;

public class Client {
	public static void main(String[] args) {

        int[][] weights = { {0, -1, 4, 0, 0},
                           {0, 0, 3, 2, 2},
                           {0, 0, 0, 0, 0},
                           {0, 1, 5, 0, 0},
                           {0, 0, 0, -3, 0}
                         };
        Graph graph = new Graph(5, weights);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);

        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(graph);
        algorithm.shortestDistance(0);
	}
}
