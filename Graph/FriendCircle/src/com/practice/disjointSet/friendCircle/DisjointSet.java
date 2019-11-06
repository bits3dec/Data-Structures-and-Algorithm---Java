package com.practice.disjointSet.friendCircle;

import java.util.*;

public class DisjointSet {
	Map<Integer, Integer> parents;
	Map<Integer, Integer> sizes;
	int max;
	
	public DisjointSet() {
		parents = new HashMap<Integer, Integer>();
		sizes = new HashMap<Integer, Integer>();
		max = Integer.MIN_VALUE;
	}
	
	int find(int v) {
		while(v != parents.get(v)) {
			int parent = parents.get(v);
			parents.put(v, parents.get(parent));
			v = parents.get(v);
		}		
		return v;
	}
	
	void union(int v1, int v2) {
		if(parents.containsKey(v1) == false) {
			parents.put(v1,	v1);
			sizes.put(v1, 1);
		}
		if(parents.containsKey(v2) == false) {
			parents.put(v2, v2);
			sizes.put(v2, 1);
		}
		
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1 == p2) {
			return;
		}
		int s1 = sizes.get(p1);
		int s2 = sizes.get(p2);
		if(s1 > s2) {
			parents.put(p2, p1);
			sizes.put(p1, s1 + s2);
		} else {
			parents.put(p1, p2);
			sizes.put(p2, s1 + s2);
		}
		if(s1 + s2 > max) {
			max = s1 + s2;
		}
	}
}
