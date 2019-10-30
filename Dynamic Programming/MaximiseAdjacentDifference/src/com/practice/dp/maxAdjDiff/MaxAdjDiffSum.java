package com.practice.dp.maxAdjDiff;

public class MaxAdjDiffSum {
	public static int maximumSum(int arr[]) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		int n = arr.length;
		
		//t[j][0] -> denotes the maximum sum adjacent differences upto first "j+1" elements with arr[j] modified to "1"
		//t[j][1] -> denotes the maximum sum adjacent differences upto first "j+1" elements with arr[j] unchanged
		int t[][] = new int[n][2];
		
		for(int j = 0; j <= n-2; ++j) {
			/*
			 * t[j+1][0] = max(t[j][0] + |1 - 1|,  //arr[j+1] modified to "1" and arr[j] also modified to "1"
			 * 				  t[j][1] + |1 - arr[j]|	//arr[j+1] modified to "1" and arr[j] unchanged i.e. same as arr[j]
			 * 				  );
			 *  t[j+1][1] = max(t[j][0] + |arr[j+1] - 1|,  //arr[j+1] unchanged anrr[j] modified to "1"
			 * 				  t[j][1] + |arr[j+1] - arr[j]|	//arr[j+1] unchanged and also arr[j] unchanged i.e. same as arr[j]
			 * 				  );
			 */
								
			t[j+1][0] = Math.max(t[j][0], 
								t[j][1] + Math.abs(1 - arr[j]));
			t[j+1][1] = Math.max(t[j][0] + Math.abs(arr[j+1]- 1),
								t[j][1] + Math.abs(arr[j+1] - arr[j]));
		}
		
		return Math.max(t[n-1][0], t[n-1][1]);
	}
}
