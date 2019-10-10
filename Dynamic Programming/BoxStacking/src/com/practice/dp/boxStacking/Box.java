package com.practice.dp.boxStacking;

public class Box {
	 int height;
     int width;
     int length;

     public Box(int height, int width, int length) {
         this.height = height;
         this.width = width;
         this.length = length;
     }
	
	public int baseArea() {
		return length * width;
	}
}
