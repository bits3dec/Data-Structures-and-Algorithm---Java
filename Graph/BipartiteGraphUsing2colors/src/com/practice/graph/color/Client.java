package com.practice.graph.color;

public class Client {
	public static void main(String[] args) {
		 Graph graph1 = new Graph(5);
         graph1.addEdge(0, 1);
         graph1.addEdge(1, 2);
         graph1.addEdge(2, 3);
         graph1.addEdge(3, 4);
         graph1.addEdge(4, 0);
         
         if(GraphColorUtil.isBipartite(graph1) == true) {
        	 System.out.println("The graph can be colored with 2 colors.\nIt is Bipartite graph");
         } else {
        	 System.out.println("The graph cannot be colored with 2 colors.\nIt is not a Bipartite graph");
         }
        	 

         Graph graph2 = new Graph(6);
         graph2.addEdge(0, 1);
         graph2.addEdge(1, 2);
         graph2.addEdge(2, 3);
         graph2.addEdge(3, 4);
         graph2.addEdge(4, 5);
         graph2.addEdge(5, 0);
         if (GraphColorUtil.isBipartite(graph2) == true){
        	 System.out.println("The graph can be colored with 2 colors.\nIt is Bipartite graph");
         } else {
        	 System.out.println("The graph cannot be colored with 2 colors.\nIt is not a Bipartite graph");
         }
	}
}
