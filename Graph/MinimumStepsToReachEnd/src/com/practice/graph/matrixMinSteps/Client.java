package com.practice.graph.matrixMinSteps;

public class Client {
	public static void main (String[] args) {
		int arr[][] = { {2, 1, 2},
						{1, 1, 1},
						{1, 1, 1}
                      };  
    
        int minSteps = MinimumStepsUtil.getMinSteps(arr);
        System.out.println(minSteps); 
	} 
}
