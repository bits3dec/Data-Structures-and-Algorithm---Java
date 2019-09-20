package com.practice.graph.snakeAndLadder;

public class Client {
	public static void main(String[] args) {
		int n = 30;
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = -1;        	
        }

        // Ladders  
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes  
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
       
		int start = 0;
		SnakeAndLadder game = new SnakeAndLadder(moves, n);
		System.out.println("Min Dice throws required is: "+ game.getMinThrows(start));
	}
}
