package com.practice.graph.shortestDistanceWithoutPQ;

import java.util.Map;
import java.util.HashMap;

public class NodeCollection {
	private final Map<Integer, Integer> nodeByDistance = new HashMap<Integer, Integer>();
	
	public void insert(int node, int distance) {
		nodeByDistance.put(node, distance);
	}
	
	public int deleteMin() {
		if(nodeByDistance.size() == 0) {
			System.out.println("No items present !!!");
			return Integer.MAX_VALUE;
		}
		
		int minDistance = Integer.MAX_VALUE;
		int minNode = -1;
		
		for(Map.Entry<Integer, Integer> entry : nodeByDistance.entrySet()) {
			int node = entry.getKey();
			int distance = entry.getValue();
			if(distance < minDistance) {
				minDistance = distance;
				minNode = node;
			}
		}		
		nodeByDistance.remove(minNode);
		return minNode;
	}
}
