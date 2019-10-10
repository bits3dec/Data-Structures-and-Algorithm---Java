package com.practice.dp.boxStacking;

import java.util.Arrays;

public class BoxStacking {
	public static int maxHeight(Box boxes[]) {
		int n = boxes.length;

        //Create a new array of boxes considering the rotations of each boxes i.e. each box will have 3 kinds after rotation
        //Assume Width > Length for simplicity
        Box[] rotatedBoxes = new Box[3 * n];
        int newLength = rotatedBoxes.length;

        for (int i = 0; i < n; ++i)
        {
            Box box = boxes[i];
            rotatedBoxes[3 * i] = new Box(box.height, Math.max(box.length, box.width), Math.min(box.length, box.width));
            rotatedBoxes[3 * i+1] = new Box(box.length, Math.max(box.height, box.width), Math.min(box.height, box.width));
            rotatedBoxes[3 * i+2] = new Box(box.width, Math.max(box.length, box.height), Math.min(box.length, box.height));
        }

        Arrays.sort(rotatedBoxes, (box1, box2) -> box2.baseArea() - box1.baseArea());

        //Problem is now reduced to finding similar to LIS(longest decreasing subsequence w.r.t base dimensions) 
        //for the rotated boxes
        //t[j] means the maximum height we can get with box[j] on top of the stack
        int[] t = new int[newLength];

        for (int i = 0; i < newLength; ++i) {
        	t[i] = rotatedBoxes[i].height;
        }   

        for (int j = 1; j < newLength; ++j) {
            Box topBox = rotatedBoxes[j];
            for (int i = 0; i < j; ++i) {
                Box bottomBox = rotatedBoxes[i];
                if (isStackingValid(bottomBox, topBox) && t[i] + topBox.height > t[j]) {
                    t[j] = t[i] + topBox.height;
                }
            }
        }
        
        int maxHeight = max(t);
        return maxHeight;
	}
	
    private static boolean isStackingValid(Box bottomBox, Box topBox)
    {
        if (bottomBox.width > topBox.width && bottomBox.length > topBox.length) {
        	return true;
        }
        return false;
    }

    private static int max(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
