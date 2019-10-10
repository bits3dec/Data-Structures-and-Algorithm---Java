package com.practice.dp.boxStacking;

public class Client {
	public static void main(String[] args) {
		 Box[] boxes = new Box[4];
         boxes[0] = new Box(4, 6, 7);
         boxes[1] = new Box(1, 2, 3);
         boxes[2] = new Box(4, 5, 6);
         boxes[3] = new Box(10, 12, 32);
        
        int res = BoxStacking.maxHeight(boxes);
        System.out.println(res);
	}
}
