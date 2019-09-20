package com.practice.graph.chessKnight;

public class Client {
	public static void main(String[] args) {
		int n = 31;
		int startingX = 0;
		int startingY = 0;
		int endingX = 30;
		int endingY = 30;
		
		ChessKnight game = new ChessKnight(startingX, startingY, endingX, endingY, n);
        int minSteps = game.getMinSteps();

        if(minSteps != Integer.MAX_VALUE)
            System.out.println("The min steps for the knight to reach the destination is: " + minSteps);
        else
            System.out.println("The destination is not reachable");
	}
}
