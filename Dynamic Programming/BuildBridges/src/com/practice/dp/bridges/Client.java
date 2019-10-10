package com.practice.dp.bridges;

public class Client {
	public static void main(String[] args) {
		CityPair cityA = new CityPair(6, 2);
        CityPair cityB = new CityPair(4, 3);
        CityPair cityC = new CityPair(2, 6);
        CityPair cityD = new CityPair(1, 5);       
        CityPair[] cityPairs = { cityA, cityB, cityC, cityD };
        
        int res = Bridges.maxBridges(cityPairs);
        System.out.println(res);
	}
}
