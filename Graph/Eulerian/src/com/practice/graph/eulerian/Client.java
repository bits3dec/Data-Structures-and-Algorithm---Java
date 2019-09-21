package com.practice.graph.eulerian;

public class Client {
	public static void main(String[] args) {
		Eulerian test = new Eulerian();
		
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        test.checkEulerian(g1);

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        test.checkEulerian(g2);

        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        test.checkEulerian(g3);

        // Let us create a graph with 3 vertices 
        // connected in the form of cycle 
        Graph g4 = new Graph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        test.checkEulerian(g4);

        // Let us create a graph with all vertices 
        // with zero degree 
        Graph g5 = new Graph(3);
        test.checkEulerian(g5);
	}
}
