package com.practice.disjointSet.friendCircle;

public class Client {
	public static void main(String[] args) {
		int queries[][] = { {1, 2},
							{3, 4},
							{2, 3}
						  };

		int n = queries.length;
		
		DisjointSet uf = new DisjointSet();
        int res[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            uf.union(queries[i][0], queries[i][1]);
            res[i] = uf.max;
        }
	
	    print(res);
	}
	
	static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
	}
}
